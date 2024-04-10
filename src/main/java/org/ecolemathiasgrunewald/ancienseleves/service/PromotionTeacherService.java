package org.ecolemathiasgrunewald.ancienseleves.service;

import org.ecolemathiasgrunewald.ancienseleves.model.PromotionTeacher;
import org.ecolemathiasgrunewald.ancienseleves.repository.PromotionTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionTeacherService {

    @Autowired
    private PromotionTeacherRepository promotionTeacherRepository;

    public Iterable<PromotionTeacher> findByPromotionId(Integer id) {
        return promotionTeacherRepository.findByPromotionId(id);
    }



}
