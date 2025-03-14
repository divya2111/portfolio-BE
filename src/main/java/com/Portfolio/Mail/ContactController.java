package com.Portfolio.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins="https://divyaparuchuri.netlify.app/")
public class ContactController {

    private final MailService mailService;

    @Autowired
    public ContactController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitContactForm(@RequestBody ContactRequest request) {
        if (request.getName() == null || request.getEmail() == null || request.getMessage() == null) {
            return ResponseEntity.badRequest().body("All fields (name, email, message) are required.");
        }

        String subject = "New Contact Request from " + request.getName();
        String content = "Name: " + request.getName() + "\nEmail: " + request.getEmail() + "\nMessage: " + request.getMessage();

        String response = mailService.sendEmail("divyaparuchuri2111@gmail.com", subject, content);
        return ResponseEntity.ok(response);
    }
}
