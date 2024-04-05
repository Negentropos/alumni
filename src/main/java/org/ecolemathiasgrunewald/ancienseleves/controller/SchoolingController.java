package org.ecolemathiasgrunewald.ancienseleves.controller;

import java.util.Optional;
import org.ecolemathiasgrunewald.ancienseleves.model.Classroom;
import org.ecolemathiasgrunewald.ancienseleves.model.Promotion;
import org.ecolemathiasgrunewald.ancienseleves.model.Schooling;
import org.ecolemathiasgrunewald.ancienseleves.service.ClassroomService;
import org.ecolemathiasgrunewald.ancienseleves.service.PromotionService;
import org.ecolemathiasgrunewald.ancienseleves.service.SchoolingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SchoolingController {

    @Autowired
    private SchoolingService schoolingService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/schoolings/{id}")
    public String schooling(@PathVariable("id") final int id, Model model) {
        Optional<Schooling> schooling = schoolingService.getSchooling(id);
        if (schooling.isPresent()){
            Iterable<Classroom> classrooms = classroomService.getClassrooms();
            Iterable<Promotion> promotions = promotionService.getPromotions();
            model.addAttribute("schooling",schooling.get());
            model.addAttribute("classrooms", classrooms);
            model.addAttribute("promotions", promotions);
            return "schooling/updateSchooling";
        }
        else {
            return "schooling/notFound";
        }
    }

    @PostMapping("/saveSchooling")
	public ModelAndView saveSchooling(@ModelAttribute Schooling schooling) {
		schoolingService.saveSchooling(schooling);
		return new ModelAndView("redirect:/alumnis");	
	}

}
