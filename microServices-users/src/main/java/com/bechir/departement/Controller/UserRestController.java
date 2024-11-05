	package com.bechir.departement.Controller;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.bechir.departement.Service.UserService;
	import com.bechir.departement.Service.register.RegistrationRequest;
	import com.bechir.departement.entite.User;
	
	@RestController
	@CrossOrigin(origins = "http://localhost:4200")
	public class UserRestController {
		@Autowired
		UserService userService;
	
		@GetMapping("all")
		public List<User> getAllUsers() {
			return userService.findAllUsers();
		}
		
		
		@PostMapping("/register")
		public User register(@RequestBody RegistrationRequest request)
		{
			System.out.println("************");


			
			return userService.registerUser(request);
		}
		
		@GetMapping("/verifyEmail/{token}")
		 public User verifyEmail(@PathVariable("token") String token){
			return userService.validateToken(token);
		 }
		
	}