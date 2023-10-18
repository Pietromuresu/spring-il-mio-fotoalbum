package org.java;

import java.util.List;

import org.java.pojo.Photo;
import org.java.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{
	
	@Autowired
	private PhotoService photoServ;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Photo photo1 = new Photo("foto1", "Fotissima", "cccs", true);
		
		photoServ.save(photo1);
		
		List<Photo> trov = photoServ.findByTitle("foto");
		
		System.out.println(trov);
		
	}

}
