package org.ecolemathiasgrunewald.ancienseleves.repository;

import org.ecolemathiasgrunewald.ancienseleves.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {

}
