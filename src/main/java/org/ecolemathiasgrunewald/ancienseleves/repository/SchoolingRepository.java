package org.ecolemathiasgrunewald.ancienseleves.repository;

import org.ecolemathiasgrunewald.ancienseleves.model.Schooling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolingRepository extends JpaRepository<Schooling,Integer> {

}
