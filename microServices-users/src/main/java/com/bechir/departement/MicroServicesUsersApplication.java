package com.bechir.departement;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bechir.departement.Service.UserService;
import com.bechir.departement.entite.Role;
import com.bechir.departement.entite.User;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MicroServicesUsersApplication {

	@Autowired	
	UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServicesUsersApplication.class, args);
	}
	
//	@PostConstruct
//	void init_users() {
//
//	userService.addRole(new Role(null,"ADMIN"));
//	userService.addRole(new Role(null,"USER"));
//
//	userService.saveUser(new User(null,"admin","123",true,null));
//
//	userService.saveUser(new User(null,"bechir","123",true,null));
//	userService.saveUser(new User(null,"yassine","123",true,null));
//
//	userService.addRoleToUser("admin", "ADMIN");
//	userService.addRoleToUser("admin", "USER");
//	userService.addRoleToUser("bechir", "USER");
//	userService.addRoleToUser("yassine", "USER");
//	}
	
//	@Bean
//	BCryptPasswordEncoder getBCE() {
//		return new BCryptPasswordEncoder();
//	}

}
