package org.ecolemathiasgrunewald.ancienseleves.controller;

import java.util.Optional;

import org.ecolemathiasgrunewald.ancienseleves.model.Alumni;
import org.ecolemathiasgrunewald.ancienseleves.model.Classroom;
import org.ecolemathiasgrunewald.ancienseleves.service.AlumniService;
import org.ecolemathiasgrunewald.ancienseleves.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlumniController {

    @Autowired
    private AlumniService alumniService;

    @Autowired
    private ClassroomService classroomService;

    @GetMapping(value={"/","/alumnis"})
    public String alumnis(Model model) {
        Iterable<Alumni> listAlumnis = alumniService.getAlumnis();
        model.addAttribute("alumnis",listAlumnis);
        return "alumnis/alumnis";
    }

    @GetMapping("/alumnis/{id}")
    public String alumni(@PathVariable("id") final int id, Model model) {
        Optional<Alumni> alumni = alumniService.getAlumni(id);
        Iterable<Classroom> classrooms = classroomService.getClassrooms();
        if (alumni.isPresent()){
            model.addAttribute("alumni",alumni.get());
            model.addAttribute("classrooms", classrooms);
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
