package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Publisher;
import com.sshproject.bookstore.Service.PublisherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    @Autowired
    private PublisherServiceInterface publisherServiceInterface;
    @GetMapping("api/v1/publisher")
    public List<Publisher> getAllPublishers(){
        return publisherServiceInterface.getAllPublishers();
    }
    @GetMapping("api/v1/publisher/{id}")
    public Optional<Publisher> getPublisherById(@PathVariable("id") int id){
        Optional<Publisher> publisher = publisherServiceInterface.getPublisherById(id);
        return publisher;
    }

    @PostMapping("api/v1/publisher")
    public int savePublisher(@RequestBody Publisher publisher){
        int result = publisherServiceInterface.savePublisher(publisher);
        return result;
    }

    @DeleteMapping("api/v1/publisher/{id}")
    public int deletePublisherById(@PathVariable("id") int id){
        int result = publisherServiceInterface.deletePublisherById(id);
        return result;
    }
}
