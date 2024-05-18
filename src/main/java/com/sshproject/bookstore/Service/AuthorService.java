package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Author;
import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements AuthorServiceInterface {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookServiceInterface bookService;

    @Override
    public Optional<Author> getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public int addAuthor(Author author) {
        authorRepository.save(author);
        return author.getId();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public int deleteAuthorById(int id) {
        Optional<Author> authorOptional = getAuthorById(id);
        if (authorOptional.isPresent()) {
            authorRepository.deleteById(id);
            return id;
        }
        return -1;
    }

    @Override
    public List<Book> getAuthorBooks(int id) {
        return bookService.getBooksByAuthorId(id);
    }

    @Override
    public Optional<Integer> findAuthorIdByDetails(String name, String nationality, LocalDate birthDate) {
        return authorRepository.findIdByNameAndNationalityAndBirthDate(name, nationality, birthDate);
    }
}

