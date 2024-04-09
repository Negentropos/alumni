package org.ecolemathiasgrunewald.ancienseleves.controller;

import org.ecolemathiasgrunewald.ancienseleves.model.Teacher;
import org.ecolemathiasgrunewald.ancienseleves.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public String getTeachers(Model model) {
        Iterable<Teacher> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);
        return "teachers/teachers";
    }

    @PostMapping("/teachers/saveTeacher")
	@ResponseBody
	public ModelAndView saveTeacher(@ModelAttribute Teacher teacher) {
		teacherService.saveTeacher(teacher);
		return new ModelAndView("redirect:/teachers/");
	}
    


}
