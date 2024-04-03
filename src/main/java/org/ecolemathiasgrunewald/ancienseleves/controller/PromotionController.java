package org.ecolemathiasgrunewald.ancienseleves.controller;

import java.util.Optional;

import org.ecolemathiasgrunewald.ancienseleves.model.Promotion;
import org.ecolemathiasgrunewald.ancienseleves.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PromotionController {

    @Autowired
    private PromotionService service;

    @GetMapping("/promotions")
    public String promotions(Model model) {
        Iterable<Promotion> promotions = service.getPromotions();
        model.addAttribute("promotions",promotions);
        return "promotions/promotions";
    }

    @GetMapping("/promotions/{id}")
    public String promotion(@PathVariable("id") final int id, Model model) {
        Optional<Promotion> promotion = service.getPromotion(id);
        if (promotion.isPresent()){
            model.addAttribute("promotion",promotion.get());
            return "promotions/promotion";
        }
        else {
            return "promotions/notFound";
        }
        
    }



}
