package org.ecolemathiasgrunewald.ancienseleves.service;

import org.ecolemathiasgrunewald.ancienseleves.model.Teacher;
import org.ecolemathiasgrunewald.ancienseleves.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Iterable<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }



}
