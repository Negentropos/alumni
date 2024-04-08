package org.ecolemathiasgrunewald.ancienseleves.controller;

import java.util.Optional;

import org.ecolemathiasgrunewald.ancienseleves.model.Alumni;
import org.ecolemathiasgrunewald.ancienseleves.model.Study;
import org.ecolemathiasgrunewald.ancienseleves.service.AlumniService;
import org.ecolemathiasgrunewald.ancienseleves.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudyController {

    @Autowired
    private StudyService studyService;

    @Autowired
    private AlumniService alumniService;

    @GetMapping("/alumnis/{id}/studies/")
	public String updateStudies(@PathVariable("id") final int alumniId, Model model) {
		Iterable<Study> studies = studyService.getStudiesbyAlumniId(alumniId);
		Optional<Alumni> alumni = alumniService.getAlumni(alumniId);
		if (alumni.isPresent()){
			model.addAttribute("alumni", alumni.get());
			model.addAttribute("studies", studies);
			return  "studies/studies";
		} else {
			return "studies/notFound";
		}
		
	}

	@GetMapping("/alumnis/{alumniId}/deleteStudy/{studyId}")
	public ModelAndView deleteJob(@PathVariable("alumniId") final int alumniId,@PathVariable("studyId") final int studyId, Model model) {
		studyService.deleteStudy(studyId);
		return new ModelAndView("redirect:/alumnis/" + alumniId + "/studies/");	
	}

	@PostMapping("/alumnis/{alumniId}/saveStudy")
	@ResponseBody
	public ModelAndView saveJob(@PathVariable("alumniId") final int alumniId, @ModelAttribute Study study) {
		studyService.saveStudy(study);
		return new ModelAndView("redirect:/alumnis/" + alumniId + "/studies/");
	}

}
