package com.bechir.departement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.bechir.departement.College;
@RepositoryRestResource(path = "col")
@CrossOrigin("http://localhost:4200/") 
public interface CollegeRepositroy extends  JpaRepository<College, Long>   {

}
