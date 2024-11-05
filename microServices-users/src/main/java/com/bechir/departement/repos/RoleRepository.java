package com.bechir.departement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bechir.departement.entite.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}