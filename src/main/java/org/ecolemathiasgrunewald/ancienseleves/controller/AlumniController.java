package org.ecolemathiasgrunewald.ancienseleves.controller;

import java.util.Optional;

import org.ecolemathiasgrunewald.ancienseleves.model.Alumni;
import org.ecolemathiasgrunewald.ancienseleves.model.Classroom;
import org.ecolemathiasgrunewald.ancienseleves.model.Promotion;
import org.ecolemathiasgrunewald.ancienseleves.model.Teacher;
import org.ecolemathiasgrunewald.ancienseleves.service.AlumniService;
import org.ecolemathiasgrunewald.ancienseleves.service.ClassroomService;
import org.ecolemathiasgrunewald.ancienseleves.service.PromotionService;
import org.ecolemathiasgrunewald.ancienseleves.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class AlumniController {

    @Autowired
    private AlumniService alumniService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping(value={"/alumnis"})
    public String alumnis(Model model) {
        Iterable<Alumni> listAlumnis = alumniService.getAlumnis();
        model.addAttribute("alumnis",listAlumnis);
        return "alumnis/alumnis";
    }

    @GetMapping(value={"/"})
    public String home(Model model) {
        Iterable<Promotion> promotions = promotionService.getPromotions();
        model.addAttribute("promotions",promotions);
        return "home";
    }
    

    @GetMapping("/alumnis/{id}")
    public String alumni(@PathVariable("id") final int id, Model model) {
        Optional<Alumni> alumni = alumniService.getAlumni(id);
        if (alumni.isPresent()){
            Iterable<Classroom> classrooms = classroomService.getClassrooms();
            Iterable<Promotion> promotions = promotionService.getPromotions();
            Iterable<Teacher> teachers = teacherService.getTeachers();
            model.addAttribute("alumni",alumni.get());
            model.addAttribute("classrooms", classrooms);
            model.addAttribute("promotions", promotions);
            model.addAttribute("teachers", teachers);
            return "alumnis/alumni";
        }
        else {
            return "alumnis/notFound";
        }
    }

    @PostMapping("/saveAlumni")
	public ModelAndView saveAlumni(@ModelAttribute Alumni alumni) {
		alumniService.saveAlumni(alumni);
		return new ModelAndView("redirect:/alumnis");	
	}
    

}
