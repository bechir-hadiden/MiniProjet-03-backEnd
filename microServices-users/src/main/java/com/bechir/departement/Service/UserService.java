package com.bechir.departement.Service;



import java.util.List;

import com.bechir.departement.Service.register.RegistrationRequest;
import com.bechir.departement.entite.Role;
import com.bechir.departement.entite.User;

public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	List<User> findAllUsers();
	User registerUser (RegistrationRequest request);
	
	public void sendEmailUser(User u ,String code );
	public User validateToken(String code);



}
