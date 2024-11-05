package com.bechir.departement;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomDepar", types = { Departement.class })
public interface DepartementProjection {
public String getNomDepartement();
}
