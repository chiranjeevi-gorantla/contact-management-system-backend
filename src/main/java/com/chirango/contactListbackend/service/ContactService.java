package com.chirango.contactListbackend.service;

import com.chirango.contactListbackend.model.Contact;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ContactService {
    List<Contact> getALlContacts();

    Contact createContact(Contact contact);


    boolean deleteContact(Long id);

    Contact getContactById(Long id);

    Contact updateContact(Long id, Contact contact);
}
