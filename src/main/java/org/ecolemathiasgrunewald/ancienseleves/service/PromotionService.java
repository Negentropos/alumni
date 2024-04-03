package org.ecolemathiasgrunewald.ancienseleves.service;

import java.util.Optional;

import org.ecolemathiasgrunewald.ancienseleves.model.Promotion;
import org.ecolemathiasgrunewald.ancienseleves.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository repository;

    public Iterable<Promotion> getPromotions() {
        return repository.findAll();
    }

    public Optional<Promotion> getPromotion(int id) {
        return repository.findById(id);
    }

}
