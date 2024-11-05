package com.bechir.departement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bechir.departement.College;
import com.bechir.departement.Departement;
import com.bechir.departement.DepartementDTO;
import com.bechir.departement.repos.CollegeRepositroy;
import com.bechir.departement.services.DepartementServices;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartementRestController {
	
	
	@Autowired
	CollegeRepositroy collegeRepositroy;
	
	@Autowired
	DepartementServices departementService;

	 @RequestMapping(path="all",method =RequestMethod.GET)
	public List<Departement> getAllDepartements() {
		return departementService.getAllDepartements();
	}
	
	@RequestMapping(value="/DeparByName/{nomDepartement}",method = RequestMethod.GET)
	public List<Departement> findByNomDepartementContains(@PathVariable("nomDepartement") String nomDepartement) {
	return departementService.findByNomDepartementContains(nomDepartement);
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public DepartementDTO getDepartementById(@PathVariable("id") Long id) {
//		return departementService.getDepartement(id);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
	@RequestMapping(path="/addDepar",method = RequestMethod.POST)
	public Departement createDepartement(@RequestBody Departement DepartementDTo) {
	return departementService.saveDepartement(DepartementDTo);
	}
	
//	@RequestMapping(method = RequestMethod.PUT)
//	public DepartementDTO updateDepartement(@RequestBody DepartementDTO DepartementDTo) {
//	return departementService.updateDepartement(DepartementDTo);
//	}
	
	
	@PutMapping("/departements")
	public Departement updateDepartement(@RequestBody DepartementDTO departementDto) {

	    return departementService.updateDepartement(departementDto);
	}

	
//	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	@RequestMapping(value="/delDepar/{id}",method = RequestMethod.DELETE)
	public void deleteDepartement(@PathVariable("id") Long id)
	{
		departementService.deleteDepartementById(id);
	}
		
	@RequestMapping(value = "/deparscol/{idcol}", method = RequestMethod.GET)
	public List<Departement> getDepartementByColId(@PathVariable("idcol") Long idcol) {
		return departementService.findByCollegeIdcol(idcol);
	}
	
	
	
//	@RequestMapping(method = RequestMethod.GET)
//	public List<DepartementDTO> getAllDepartement() {
//		return departementService.getAllDepartements();
//	}
//	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Departement getDepartementByIds(@PathVariable("id") Long id) {
		return departementService.getDepartement(id);
	}
	
	
//	@RequestMapping(method = RequestMethod.GET)
//	public List<College> getAllColleges() {
//		return collegeRepositroy.findAll();
//	}
//
//	@RequestMapping(value="/{id}",method = RequestMethod.GET)
//	public College getCollegeById(@PathVariable("id") Long id) {
//		return collegeRepositroy.findById(id).get();
//
//}



}
