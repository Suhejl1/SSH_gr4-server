package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Faq;
import com.sshproject.bookstore.Service.FaqServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FaqController {
    @Autowired
    private FaqServiceInterface faqInterface;

    @GetMapping("api/v1/faq")
    public ResponseEntity<List<Faq>> getAllFaqs() {
        List<Faq> faqs = faqInterface.getFaqs();
        return ResponseEntity.ok(faqs);
    }

    @PostMapping("api/v1/faq")
    public ResponseEntity<String> addFaq(@RequestBody Faq faq) {
        int new_faq_id = faqInterface.addFaq(faq);
        if (new_faq_id > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("FAQ added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add FAQ");
        }
    }

}
