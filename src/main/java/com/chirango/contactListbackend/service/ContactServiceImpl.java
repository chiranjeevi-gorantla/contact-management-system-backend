package com.chirango.contactListbackend.service;

import com.chirango.contactListbackend.exception.ResourceNotFoundException;
import com.chirango.contactListbackend.model.Contact;
import com.chirango.contactListbackend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getALlContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts;
    }

    @Override
    public Contact createContact(Contact contact) {
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public boolean deleteContact(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact doesn't exits with id: " +id));;
        contactRepository.delete(contact);
        return true;
    }

    @Override
    public Contact getContactById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact doesn't exits with id: " +id));
        return contact;
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        Contact contactInDB = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact doesn't exits with id: " +id));;
        contactInDB.setFirstName(contact.getFirstName());
        contactInDB.setLastName(contact.getLastName());
        contactInDB.setPhoneNumber(contact.getPhoneNumber());
        contactInDB.setEmailId(contact.getEmailId());
        contactRepository.save(contactInDB);
        return contact;
    }

}
