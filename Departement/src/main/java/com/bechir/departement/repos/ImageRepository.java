package com.bechir.departement.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bechir.departement.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}
