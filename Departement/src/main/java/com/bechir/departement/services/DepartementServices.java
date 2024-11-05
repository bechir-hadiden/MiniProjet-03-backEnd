package com.bechir.departement.services;

import java.util.List;

import com.bechir.departement.College;
import com.bechir.departement.Departement;
import com.bechir.departement.DepartementDTO;


public interface DepartementServices {
//	Departement saveDepartement(Departement p);
	Departement updateDepartement(DepartementDTO p);
	void deleteDepartement(Departement p);
	 void deleteDepartementById(Long id);
//	Departement getDepartement(Long id);
//	List<Departement> getAllDepartements();
	List<Departement> findByNomDepartement(String nom);
	List<Departement> findByNomDepartementContains(String nom);
	List<Departement> findByNomNombre (String nom, int nombre);
	List<Departement> findByCollege (College college);
	List<Departement> findByCollegeIdcol(Long id);
	List<Departement> findByOrderByNomDepartementAsc();
	List<Departement> trierDepartementsNomsNombre();
	
	Departement convertEntityToDto (Departement departement);
	Departement saveDepartement(Departement d);
	Departement getDepartement(Long id);
	List<Departement> getAllDepartements();
	
	 Departement updateDepartement(Departement d);

	Departement convertDtoToEntity(Departement DepartementDto);


}
