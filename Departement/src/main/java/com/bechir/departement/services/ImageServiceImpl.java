package com.bechir.departement.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import static java.lang.Integer.valueOf;

import com.bechir.departement.Departement;
import com.bechir.departement.Image;
import com.bechir.departement.repos.DepartementRepository;
import com.bechir.departement.repos.ImageRepository;

import jakarta.transaction.Transactional;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageRepository imageRepository;

	@Autowired
	DepartementServices departementServices;

	@Autowired
	DepartementRepository departementRepository ;
	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {

		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).build());
	}

	@Override
	public Image getImageDetails(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return Image.builder().idImage(dbImage.get().getIdImage()).name(dbImage.get().getName())
				.type(dbImage.get().getType()).image(dbImage.get().getImage()).build();
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
				.body(dbImage.get().getImage());
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}

	@Override
	public Image uplaodImageDepar(MultipartFile file, Long idDepar) throws IOException {
		Departement p = new Departement();
		p.setIdDepartement(idDepar);
		return imageRepository.save(Image.builder()
		 .name(file.getOriginalFilename())
		 .type(file.getContentType())
		 .image(file.getBytes())
		 .departement(p).build() );
	}

	@Override
	public List<Image> getImagesParDepar(Long DeparId) {
		Departement d = departementRepository.findById(DeparId).get();
		return d.getImages();
	}
}
