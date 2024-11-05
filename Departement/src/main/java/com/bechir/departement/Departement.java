package com.bechir.departement;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Departement {	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idDepartement;
	private String nomDepartement;
	private int nombreEmployee;
	private Date dateAffectation;
	private String imagePath;


	@ManyToOne
	private College college;
	
	 @OneToMany (mappedBy = "departement")
	 private List<Image> images;




	public Departement() {
	}

	public Departement( String nomDepartement, int nombreEmployee, Date dateAffectation) {
		
		nomDepartement = nomDepartement;
		nombreEmployee = nombreEmployee;
		this.dateAffectation = dateAffectation;
	}


	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public int getNombreEmployee() {
		return nombreEmployee;
	}

	public void setNombreEmployee(int nombreEmployee) {
		this.nombreEmployee = nombreEmployee;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public String toString() {
		return "Departement [idDepartement=" + idDepartement + ", nomDepartement=" + nomDepartement
				+ ", nombreEmployee=" + nombreEmployee + ", dateAffectation=" + dateAffectation + ", college=" + college
				+ "]";
	}

	public College getCollege() {
		return college;
	}


	public void setCollege(College college) {
		this.college = college;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	

}
	
