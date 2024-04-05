package org.ecolemathiasgrunewald.ancienseleves.service;

import java.util.Optional;

import org.ecolemathiasgrunewald.ancienseleves.model.Schooling;
import org.ecolemathiasgrunewald.ancienseleves.repository.SchoolingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolingService {
    
    @Autowired
    private SchoolingRepository schoolingRepository;

    public Schooling saveSchooling(Schooling schooling) {
        Schooling savedSchooling;
        savedSchooling = schoolingRepository.save(schooling);
        return savedSchooling;
    }

    public Optional<Schooling> getSchooling(int id) {
        return schoolingRepository.findById(id);
    }

}
