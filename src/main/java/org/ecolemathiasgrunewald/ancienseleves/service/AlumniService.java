package org.ecolemathiasgrunewald.ancienseleves.service;

import java.util.Optional;

import org.ecolemathiasgrunewald.ancienseleves.model.Alumni;
import org.ecolemathiasgrunewald.ancienseleves.repository.AlumniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumniService {

    @Autowired
    private AlumniRepository repository;

    public Iterable<Alumni> getAlumnis(){
        return repository.findAll();
    }

    public Optional<Alumni> getAlumni(Integer id) {
        return repository.findById(id);
    }


    public Alumni saveAlumni(Alumni alumni) {
		Alumni savedAlumni;
		
		savedAlumni = repository.save(alumni);
		
		return savedAlumni;
	}


}
