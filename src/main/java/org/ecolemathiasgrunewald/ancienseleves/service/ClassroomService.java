package org.ecolemathiasgrunewald.ancienseleves.service;

import org.ecolemathiasgrunewald.ancienseleves.model.Classroom;
import org.ecolemathiasgrunewald.ancienseleves.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository repository;

    public Iterable<Classroom> getClassrooms() {
        return repository.findAll();
    }

}
