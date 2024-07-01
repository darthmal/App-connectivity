package com.salam.collab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CollabApplication {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello");
		// Check the os
		var s = System.getProperty("os.name");
		SpringApplication.run(CollabApplication.class, args);
	}

//	Creating a default admin account if not exist
//	@Bean
//	CommandLineRunner run(UserService userService, UserRepository userRespo, PasswordEncoder passwordEncoder) { // Inject UserService
//		return args -> {
//
//			// Default admin user creation:
//			if (userService.finUserByUsername("admin").isEmpty()) {
//				User adminUser = new User();
//				adminUser.setFirstname("Admin");
//				adminUser.setLastName("Admin");
//				adminUser.setEmail("admin@example.com");
//				adminUser.setUsername("admin");
//				adminUser.setPassword(passwordEncoder.encode("admin"));
//				adminUser.setRole(Role.ADMIN);
//
//				userRespo.save(adminUser);
//				System.out.println("Default admin user created!");
//			}
//		};
//	}
}
