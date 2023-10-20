package org.java.auth.pojo;


import java.util.Collection;
import java.util.Set;

import org.java.pojo.Photo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class User implements UserDetails{

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="L'username è un campo obbligatorio")
	@Column(unique = true)
	private String username;
	
	@NotNull(message="L'username è un campo obbligatorio")
	private String password;

	@ManyToMany( fetch = FetchType.EAGER)
	private Set<Role> roles;

	@OneToMany
	private Set<Photo> photos;
	
	
	public User() {	};
	
	public User(String username, String password, Role ...roles ) {	
		
		 setId(id);
		 setUsername(username);
		 setPassword(password);
		 setRoles(Set.of(roles));
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles= roles;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return getRoles().stream()
				.map(r -> new SimpleGrantedAuthority(
									r.getName()
								)
				).toList();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	};
	
	
	

}
