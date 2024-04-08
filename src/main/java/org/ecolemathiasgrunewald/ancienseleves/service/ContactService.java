package org.ecolemathiasgrunewald.ancienseleves.service;

import org.ecolemathiasgrunewald.ancienseleves.model.Contact;
import org.ecolemathiasgrunewald.ancienseleves.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository ContactRepository;

    public Contact saveContact(Contact Contact) {
        Contact savedContact;

        savedContact = ContactRepository.save(Contact);
        return savedContact;
    }

    public Iterable<Contact> getContactsbyAlumniId(int alumniId) {
        return ContactRepository.findByAlumniId(alumniId);
    }

    public void deleteContact(int ContactId) {
        ContactRepository.deleteById(ContactId);
    }


}
