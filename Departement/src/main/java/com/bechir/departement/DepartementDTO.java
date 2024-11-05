package com.bechir.departement;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DepartementDTO {
	
	private Long idDepartement;
	private String nomDepartement;
	private int nombreEmployee;
	private Date dateAffectation;
	private College college;
	
	private String nomCol ;

	
	

}
