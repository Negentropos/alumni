package org.ecolemathiasgrunewald.ancienseleves.repository;

import org.ecolemathiasgrunewald.ancienseleves.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Integer> {

}
