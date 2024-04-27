package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Publisher;
import com.sshproject.bookstore.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService implements PublisherServiceInterface{
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> getPublisherById(int id){
        Optional<Publisher> publisherOptional = publisherRepository.findById(id);
        if(publisherOptional.isPresent()){
            return publisherOptional;
        }
        return null;

    }

    @Override
    public int savePublisher(Publisher publisher){
        Publisher newPublisher = new Publisher(publisher.getName(), publisher.getLocation());
        publisherRepository.save(newPublisher);
        return newPublisher.getId();
    }

    @Override
    public int deletePublisherById(int id){
        Optional<Publisher> publisherOptional = getPublisherById(id);
        if(publisherOptional.isPresent()){
            publisherRepository.deleteById(id);
            return id;
        }
        return -1;
    }
}
