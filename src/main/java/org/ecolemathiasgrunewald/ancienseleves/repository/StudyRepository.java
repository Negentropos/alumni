package org.ecolemathiasgrunewald.ancienseleves.repository;

import org.ecolemathiasgrunewald.ancienseleves.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<Study,Integer> {

    public Iterable<Study> findByAlumniId(int id);

}
