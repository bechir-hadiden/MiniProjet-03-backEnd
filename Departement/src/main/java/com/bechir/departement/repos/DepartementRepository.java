package com.bechir.departement.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bechir.departement.College;
import com.bechir.departement.Departement;

@RepositoryRestResource(path = "rest")
public interface DepartementRepository extends JpaRepository<Departement, Long>  {
	
	List<Departement> findByNomDepartement(String nomDepartement);

	
	List<Departement> findByNomDepartementContains(String nomDepartement);

	
	@Query("select d from Departement d where d.nomDepartement like %:nomDepartement and d.nombreEmployee > :nombreEmployee")
	List<Departement> findByNomNombre(@Param("nomDepartement") String nomDepartement,
			@Param("nombreEmployee") int nombreDepartement);

	@Query("select d from Departement d where d.college = ?1")
	List<Departement> findByCollege(College college);

	@Query("select d from Departement d order by d.nomDepartement ASC, d.nombreEmployee DESC")
	List<Departement> trierDepartementNomsNombre();
	

	 List<Departement>findByCollegeIdcol (Long idcol);

//	 List<Departement>findByorderByNomDepatementAsc();



}
