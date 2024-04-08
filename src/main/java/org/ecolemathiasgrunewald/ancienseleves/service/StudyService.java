package org.ecolemathiasgrunewald.ancienseleves.service;

import org.ecolemathiasgrunewald.ancienseleves.model.Study;
import org.ecolemathiasgrunewald.ancienseleves.repository.StudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyService {

    @Autowired
    private StudyRepository studyRepository;

    public Iterable<Study> getStudiesbyAlumniId(int alumniId) {
        return studyRepository.findByAlumniId(alumniId);
    }

    public void deleteStudy(int studyId) {
        studyRepository.deleteById(studyId);
    }

    public Study saveStudy(Study study) {
        Study savedStudy = studyRepository.save(study);
        return savedStudy;
    }

}
