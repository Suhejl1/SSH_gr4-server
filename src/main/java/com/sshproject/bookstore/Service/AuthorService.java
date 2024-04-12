package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Author;
import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements AuthorServiceInterface{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public int deleteAuthorById(int id) {
        Optional<Author> author_optional = getAuthorById(id);
        if(author_optional.isPresent()){
            authorRepository.deleteById(id);
            return id;
        }
        return -1;
    }

    @Override
    public int addAuthor(Author author) {
        Author new_author = new Author(author.getName(),author.getNationality(),author.getBirth_date());
        authorRepository.save(new_author);
        return new_author.getId();
    }


    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(int id) {
        Optional<Author> author =  authorRepository.findById(id);
        if (author.isPresent()) {
            return author;
        }
        return null;
    }

//    @Override
//    public List<Book> getAuthorBooks(int id) {
//        return bookService.getBooksByAuthorId(id);
//    }
}
