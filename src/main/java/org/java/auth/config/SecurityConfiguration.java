package org.java.auth.config;

import org.java.auth.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http)
		throws Exception {
			 
		http.csrf().disable()
			.authorizeHttpRequests()
	        // ADMIN AUTHORIZATION
			// PIZZAS
			.requestMatchers("/api/v1.0/**").permitAll()
			.requestMatchers("/imgs/**").permitAll()
			.requestMatchers("/name").permitAll()
			.requestMatchers("/").permitAll()
			// MESSAGES
			.requestMatchers("/message/**").permitAll()
//			.requestMatchers("/api/v1.0/**").permitAll()
//			.requestMatchers("/imgs/**").permitAll()
			.requestMatchers("/post/**").permitAll()
	        .requestMatchers("/add").hasAuthority("ADMIN")
	        .requestMatchers("/update/**").hasAuthority("ADMIN")
	        .requestMatchers("/delete/**").hasAuthority("ADMIN")
	        // CATEGORIES
	        .requestMatchers("/categories/**").hasAuthority("ADMIN")
	        .requestMatchers("/test/\\d").hasAnyAuthority("ADMIN")
//	        // USER AUTHORIZATION
	        .requestMatchers("/**").hasAuthority("USER")
	        .and().formLogin().defaultSuccessUrl("/")
	        .and().logout();
			 
			return http.build();
	}
	
	@Bean
	UserService userDetailsService() {
		return new UserService();
	}

    @Bean
    PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
    
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
   
      authProvider.setUserDetailsService(userDetailsService());
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
    }
	
	
}
