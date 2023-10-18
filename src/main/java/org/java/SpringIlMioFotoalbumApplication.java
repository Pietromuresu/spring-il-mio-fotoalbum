package org.java;

import java.util.List;

import org.java.pojo.Category;
import org.java.pojo.Photo;
import org.java.services.CategoryService;
import org.java.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{
	
	@Autowired
	private PhotoService photoServ;

	@Autowired
	private CategoryService categoryServ;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category("Funny", "Divertentissima");
		categoryServ.save(cat1);
		
		Category cat2 = new Category("Okd ", "Divertentissima");
		categoryServ.save(cat2);
		
		Category cat3 = new Category("Vad", "Divertentissima");
		categoryServ.save(cat3);
		
		Category cat4 = new Category("Bene", "Divertentissima");
		categoryServ.save(cat4);
		
		Photo photo1 = new Photo("foto1", "Fotissima", "test.jpeg", true, cat1, cat3);
		photoServ.save(photo1);

		Photo photo2 = new Photo("foto2", "Fotissifma", "test2.jpeg", true, cat4, cat2);
		photoServ.save(photo2);
		
		Photo photo3 = new Photo("foto2", "Fotissifma", "test-vert.jpeg", true, cat4, cat2);
		photoServ.save(photo3);
		
		Photo photo4 = new Photo("foto1", "Fotissima", "test.jpeg", true, cat1, cat3);
		photoServ.save(photo4);
		
		Photo photo5 = new Photo("foto2", "Fotissifma", "test2.jpeg", true, cat4, cat2);
		photoServ.save(photo5);
		
		Photo photo6 = new Photo("foto2", "Fotissifma", "test-vert.jpeg", true, cat4, cat2);
		photoServ.save(photo6);
		
		List<Photo> trov = photoServ.findByTitle("foto");
		
		System.out.println(trov);
		
	}

}
