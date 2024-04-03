package org.ecolemathiasgrunewald.ancienseleves.controller;

import java.util.Optional;

import org.ecolemathiasgrunewald.ancienseleves.model.Alumni;
import org.ecolemathiasgrunewald.ancienseleves.service.AlumniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class AlumniController {

    @Autowired
    private AlumniService service;

    @GetMapping("/alumnis")
    public String alumnis(Model model) {
        Iterable<Alumni> listAlumnis = service.getAlumnis();
        model.addAttribute("alumnis",listAlumnis);
        return "alumnis/alumnis";
    }

    @GetMapping("/alumnis/{id}")
    public String alumni(@PathVariable("id") final int id, Model model) {
        Optional<Alumni> alumni = service.getAlumni(id);
        if (alumni.isPresent()){
            model.addAttribute("alumni",alumni.get());
            return "alumnis/alumni";
        }
        else {
            return "alumnis/notFound";
        }
        
    }
    
    

}
