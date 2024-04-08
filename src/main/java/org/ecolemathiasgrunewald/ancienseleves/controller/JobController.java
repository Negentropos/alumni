package org.ecolemathiasgrunewald.ancienseleves.controller;

import java.util.Optional;

import org.ecolemathiasgrunewald.ancienseleves.model.Alumni;
import org.ecolemathiasgrunewald.ancienseleves.model.Job;
import org.ecolemathiasgrunewald.ancienseleves.service.AlumniService;
import org.ecolemathiasgrunewald.ancienseleves.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
public class JobController {

    @Autowired
    private JobService jobService;

	@Autowired
	private AlumniService alumniService;


	@GetMapping("/alumnis/{id}/jobs/")
	public String updateJobs(@PathVariable("id") final int alumniId, Model model) {
		Iterable<Job> jobs = jobService.getJobsbyAlumniId(alumniId);
		Optional<Alumni> alumni = alumniService.getAlumni(alumniId);
		if (alumni.isPresent()){
			Job newJob = new Job();
			model.addAttribute("newJob",newJob);
			model.addAttribute("alumni", alumni.get());
			model.addAttribute("jobs", jobs);
			return  "jobs/updateJobs";
		} else {
			return "jobs/notFound";
		}
		
	}

	@GetMapping("/alumnis/{alumniId}/deleteJob/{jobId}")
	public String deleteJob(@PathVariable("alumniId") final int alumniId,@PathVariable("jobId") final int jobId, Model model) {
		jobService.deleteJob(jobId);
		Optional<Alumni> alumni = alumniService.getAlumni(alumniId);
		Iterable<Job> jobs = jobService.getJobsbyAlumniId(alumniId);
		if (alumni.isPresent()){
			model.addAttribute("alumni", alumni.get());
			model.addAttribute("jobs", jobs);
			return  "jobs/updateJobs";
		} else {
			return "jobs/notFound";
		}
	}

	@PostMapping("/saveJob")
	@ResponseBody
	public ModelAndView saveJob(@ModelAttribute Job job) {
		jobService.saveJob(job);
		return new ModelAndView("redirect:/alumnis");	
	}

	@PostMapping("/saveNewJob")
	public ModelAndView saveNewJob(@ModelAttribute("newJob") Job newJob) {
		jobService.saveJob(newJob);
		return new ModelAndView("redirect:/alumnis");	
	}



}
