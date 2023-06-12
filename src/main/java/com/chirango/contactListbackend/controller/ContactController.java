package com.chirango.contactListbackend.controller;

import com.chirango.contactListbackend.model.Contact;
import com.chirango.contactListbackend.repository.ContactRepository;
import com.chirango.contactListbackend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ContactController {

    @Autowired
    private ContactService contactService;

    //get all Contacts
    @GetMapping("/contacts")
    public List<Contact> getALlContacts() {
        return contactService.getALlContacts();
    }

    //get contact by ID
    @GetMapping("/contacts/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    //create contact
    @PostMapping("/contacts")
    public Contact createContact(@RequestBody Contact contact){
        return contactService.createContact(contact);
    }

    //update/edit contact by ID
    @PutMapping("/contacts/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        contact = contactService.updateContact(id, contact);
        return ResponseEntity.ok(contact);
    }

    //delete contact by ID
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteContact(@PathVariable Long id) {
        boolean deleted = false;
        deleted = contactService.deleteContact(id);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return ResponseEntity.ok(response);

    }
}
