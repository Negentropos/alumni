package org.ecolemathiasgrunewald.ancienseleves.controller;

import java.util.Optional;

import org.ecolemathiasgrunewald.ancienseleves.model.Alumni;
import org.ecolemathiasgrunewald.ancienseleves.model.Contact;
import org.ecolemathiasgrunewald.ancienseleves.service.AlumniService;
import org.ecolemathiasgrunewald.ancienseleves.service.ContactService;
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
public class ContactController {

    @Autowired
    private ContactService contactService;

	@Autowired
	private AlumniService alumniService;


	@GetMapping("/alumnis/{id}/contacts/")
	public String updatecontacts(@PathVariable("id") final int alumniId, Model model) {
		Iterable<Contact> contacts = contactService.getContactsbyAlumniId(alumniId);
		Optional<Alumni> alumni = alumniService.getAlumni(alumniId);
		if (alumni.isPresent()){
			model.addAttribute("alumni", alumni.get());
			model.addAttribute("contacts", contacts);
			return  "contacts/contacts";
		} else {
			return "contacts/notFound";
		}
		
	}

	@GetMapping("/alumnis/{alumniId}/deleteContact/{contactId}")
	public ModelAndView deleteContact(@PathVariable("alumniId") final int alumniId,@PathVariable("contactId") final int contactId, Model model) {
		contactService.deleteContact(contactId);
		return new ModelAndView("redirect:/alumnis/" + alumniId + "/contacts/");	
	}

	@PostMapping("/alumnis/{alumniId}/saveContact")
	@ResponseBody
	public ModelAndView saveContact(@PathVariable("alumniId") final int alumniId, @ModelAttribute Contact contact) {
		contactService.saveContact(contact);
		return new ModelAndView("redirect:/alumnis/" + alumniId + "/contacts/");
	}

}
