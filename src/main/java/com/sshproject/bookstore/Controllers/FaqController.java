package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Faq;
import com.sshproject.bookstore.Service.FaqServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faq")
public class FaqController {

    @Autowired
    private FaqServiceInterface faqInterface;

    @GetMapping
    public ResponseEntity<List<Faq>> getAllFaqs() {
        List<Faq> faqs = faqInterface.getFaqs();
        return ResponseEntity.ok(faqs);
    }

    @PostMapping
    public ResponseEntity<String> addFaq(@RequestBody Faq faq, @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || !isValidToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        try {
            int newFaqId = faqInterface.addFaq(faq);
            if (newFaqId > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("FAQ added successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add FAQ");
            }
        } catch (Exception e) {
            // Log the error for debugging
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFaqAnswer(@PathVariable int id, @RequestBody Faq updatedFaq, @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || !isValidToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        try {
            boolean isUpdated = faqInterface.updateFaqAnswer(id, updatedFaq.getAnswer());
            if (isUpdated) {
                return ResponseEntity.ok("FAQ answer updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FAQ not found");
            }
        } catch (Exception e) {
            // Log the error for debugging
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }


    private boolean isValidToken(String token) {
        // Implement token validation logic here
        // This might involve decoding the token and checking its validity, expiration, etc.
        return true; // Placeholder for actual validation logic
    }
}
