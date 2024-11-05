package com.bechir.departement.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bechir.departement.Departement;
import com.bechir.departement.DepartementDTO;
import com.bechir.departement.Image;
import com.bechir.departement.services.DepartementServices;
import com.bechir.departement.services.ImageService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;
	
	@Autowired
	DepartementServices departementServices;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@PostMapping(value = "/uplaodImageDepar/{idDepar}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idDepar") Long idProd)
			throws IOException {
		return imageService.uplaodImageDepar(file, idProd);
	}

	@RequestMapping(value = "/getImagesProd/{idProd}", method = RequestMethod.GET)
	public List<Image> getImagesProd(@PathVariable("idProd") Long idDepar) throws IOException {
		return imageService.getImagesParDepar(idDepar);
	}
	
	
	@RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile
	file,@PathVariable("id") Long id) throws IOException {
		Departement d = departementServices.getDepartement(id);
	 d.setImagePath(id+".jpg");

	Files.write(Paths.get(System.getProperty("user.home")+"/images/"+d.getImagePath())
	, file.getBytes());
	 departementServices.saveDepartement(d);

	 }
	 @RequestMapping(value = "/loadfromFS/{id}" ,
	 method = RequestMethod.GET,
	 produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

	 Departement p = departementServices.getDepartement(id);
	 return
	Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
	 }

}