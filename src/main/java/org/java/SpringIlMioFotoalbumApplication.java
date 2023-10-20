package org.java;

import java.util.List;

import org.java.auth.pojo.User;
import org.java.auth.pojo.Role;
import org.java.auth.repositories.RoleRepo;
import org.java.auth.repositories.UserRepo;
import org.java.pojo.Category;
import org.java.pojo.Photo;
import org.java.services.CategoryService;
import org.java.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{
	
	@Autowired
	private PhotoService photoServ;

	@Autowired
	private CategoryService categoryServ;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;


	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Role admin = new Role("ADMIN");
		Role superAdmin = new Role("SUPER-ADMIN");
		
		roleRepo.save(admin);
		roleRepo.save(superAdmin);
		
		
		final String pwsAdmin = new BCryptPasswordEncoder().encode("123");
		final String pwsSuper = new BCryptPasswordEncoder().encode("123");
		
		User ceo = new User("pietroCeo", pwsAdmin, admin);
		User user = new User("user", pwsAdmin, admin);
		User god = new User("Super", pwsSuper, superAdmin);

		
		userRepo.save(ceo);
		userRepo.save(god);
		userRepo.save(user);
		
		
		
		Category paesaggi = new Category("Paesaggi", "Foto di paesaggi");
		categoryServ.save(paesaggi);
		
		Category persone = new Category("Persone ", "foto di persone ");
		categoryServ.save(persone);
		
		Category posti = new Category("posti", "Foto di posti");
		categoryServ.save(posti);
		
		Category famosi = new Category("Famosi", "Foto di personaggi famosi");
		categoryServ.save(famosi);
		
		Category astratti = new Category("Astratti", "Foto di forme");
		categoryServ.save(astratti);
		
		Photo beatles = new Photo("The Beatles", "Attraversano la strada", "beatles.jpeg", true, user, persone, famosi);
		photoServ.save(beatles);

		Photo facciaCane = new Photo("Faccia di cane", "Donna con la faccia da cane", "faccia-cane.jpeg", true, ceo, persone, astratti);
		photoServ.save(facciaCane);
		
		Photo museum = new Photo("Museo", "Fotissifma", "museum.jpeg", true, ceo, persone, posti);
		photoServ.save(museum);
		
		Photo oldMe = new Photo("Old me", "Me da vecchio", "old-me.jpeg", true, ceo, persone);
		photoServ.save(oldMe);
		
		Photo youngBoy = new Photo("Young Boy", "Bambino ", "young-boy.jpeg", true, ceo, persone);
		photoServ.save(youngBoy);
		
		Photo raffaella = new Photo("Raffaella Carrà", "Raffaella carrà in tv", "raffaella.webp", true, ceo, famosi, persone);
		photoServ.save(raffaella);
		
		Photo ungaretti = new Photo("Giuseppe ungaretti", "Ungaretti famoso scrittore in compagnia", "ungaretti.webp", true, ceo, famosi, persone);
		photoServ.save(ungaretti);

		Photo top = new Photo("Top model", "Donatella versace e delle top model", "top-model.webp", true, ceo, famosi, persone);
		photoServ.save(top);
		
		
		
		
		List<Photo> trov = photoServ.findByTitle("foto");
		
		System.out.println(trov);
		
	}

}
