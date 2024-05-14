package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Publisher;
import com.sshproject.bookstore.Service.PublisherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    @Autowired
    private PublisherServiceInterface publisherServiceInterface;
    @GetMapping("api/v1/publisher")
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publishers = publisherServiceInterface.getAllPublishers();
        if (publishers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(publishers);
        }
    }
    @GetMapping("api/v1/publisher/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable("id") int id) {
        Optional<Publisher> publisher = publisherServiceInterface.getPublisherById(id);
        return publisher.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("api/v1/publisher")
    public ResponseEntity<String> savePublisher(@RequestBody Publisher publisher) {
        int result = publisherServiceInterface.savePublisher(publisher);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Publisher saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save publisher");
        }
    }

    @DeleteMapping("api/v1/publisher/{id}")
    public ResponseEntity<String> deletePublisherById(@PathVariable("id") int id) {
        int result = publisherServiceInterface.deletePublisherById(id);
        if (result > 0) {
            return ResponseEntity.ok("Publisher deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publisher not found");
        }
    }
}
