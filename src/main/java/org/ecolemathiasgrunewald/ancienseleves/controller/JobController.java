package org.ecolemathiasgrunewald.ancienseleves.controller;

import org.ecolemathiasgrunewald.ancienseleves.model.Job;
import org.ecolemathiasgrunewald.ancienseleves.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/saveJob")
	public ModelAndView saveJob(@ModelAttribute Job job) {
		jobService.saveJob(job);
		return new ModelAndView("redirect:/alumnis");	
	}

}
