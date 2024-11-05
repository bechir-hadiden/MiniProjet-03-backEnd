package com.bechir.departement.services;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.bechir.departement.Image;

public interface ImageService {
	
	 Image uplaodImage(MultipartFile file) throws IOException;
	 Image getImageDetails(Long id) throws IOException;
	 ResponseEntity<byte[]> getImage(Long id) throws IOException;
	 void deleteImage(Long id) ;
	 
	 
	 
	 Image uplaodImageDepar(MultipartFile file,Long idDepar) throws IOException;
	 List<Image> getImagesParDepar(Long DeparId);


}
