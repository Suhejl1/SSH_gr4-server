package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Publisher;
import java.util.List;
import java.util.Optional;

public interface PublisherServiceInterface {
    List<Publisher> getAllPublishers();
    Optional<Publisher> getPublisherById(int id);
    int savePublisher(Publisher publisher);
    int deletePublisherById(int id);

}
