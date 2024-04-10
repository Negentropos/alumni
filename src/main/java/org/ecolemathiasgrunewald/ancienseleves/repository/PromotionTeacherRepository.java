package org.ecolemathiasgrunewald.ancienseleves.repository;

import org.ecolemathiasgrunewald.ancienseleves.model.PromotionTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionTeacherRepository  extends JpaRepository<PromotionTeacher,Integer> {

    public Iterable<PromotionTeacher> findByPromotionId(int id);

}
