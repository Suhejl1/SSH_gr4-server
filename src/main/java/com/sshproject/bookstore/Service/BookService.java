package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.DTO.BookRequestDTO;
import com.sshproject.bookstore.Entity.*;
import com.sshproject.bookstore.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookGenreRelationshipRepository bookGenreRelationshipRepository;

    @Override
    public int addBook(BookRequestDTO bookRequestDTO) {
        // Check if book with the given ISBN already exists
        Optional<Book> existingBook = bookRepository.findByIsbn(bookRequestDTO.getIsbn());
        if (existingBook.isPresent()) {
            return -1; // Indicating that the book already exists
        }

        // Handle author
        Optional<Author> authorIdOpt = authorRepository.findByNameAndNationalityAndBirthDate(
                bookRequestDTO.getAuthorName(), bookRequestDTO.getAuthorNationality(), bookRequestDTO.getAuthorBirthDate()
        );

        int authorId;
        if (authorIdOpt.isPresent()) {
            authorId = authorIdOpt.get().getId();
        } else {
            Author author = new Author(bookRequestDTO.getAuthorName(), bookRequestDTO.getAuthorNationality(), bookRequestDTO.getAuthorBirthDate());
            authorRepository.save(author);
            authorId = author.getId();
        }

        // Handle publisher
        Optional<Publisher> publisherIdOpt = publisherRepository.findByNameAndLocation(
                bookRequestDTO.getPublisherName(), bookRequestDTO.getPublisherLocation()
        );

        int publisherId;
        if (publisherIdOpt.isPresent()) {
            publisherId = publisherIdOpt.get().getId();
        } else {
            Publisher publisher = new Publisher(bookRequestDTO.getPublisherName(), bookRequestDTO.getPublisherLocation());
            publisherRepository.save(publisher);
            publisherId = publisher.getId();
        }

        // Handle inventory
        Inventory inventory = new Inventory(bookRequestDTO.getQuantity(), LocalDate.now(), LocalDate.now());
        inventoryRepository.save(inventory);

        // Create book
        Book book = new Book(
                bookRequestDTO.getTitle(),
                authorId,
                bookRequestDTO.getIsbn(),
                publisherId,
                bookRequestDTO.getPublishingYear(),
                bookRequestDTO.getPrice(),
                bookRequestDTO.getImage(),
                bookRequestDTO.getDescription(),
                inventory.getId()
        );
        Book savedBook = bookRepository.save(book);

        // Handle genres
        for (String genreName : bookRequestDTO.getGenres()) {
            Optional<Genre> genreOpt = genreRepository.findByName(genreName);
            int genreId = genreOpt.get().getId();
            BookGenreRelationship bookGenreRelationship = new BookGenreRelationship(savedBook.getId(), genreId);
            bookGenreRelationshipRepository.save(bookGenreRelationship);
        }

        return savedBook.getId();
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Integer> deleteBooks() {
        List<Book> deletedBooks = bookRepository.findAll();
        List<Integer> deletedBookIds = new ArrayList<>();
        for (Book book : deletedBooks) {
            deletedBookIds.add(book.getId());
        }
        bookRepository.deleteAll();
        return deletedBookIds;
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public String updateBook(int id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setImage(updatedBook.getImage());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setPublishing_year(updatedBook.getPublishing_year());
            existingBook.setInventory_id(updatedBook.getInventory_id());
            bookRepository.save(existingBook);
            return "Book updated";
        } else {
            return "Could not update book";
        }
    }

    @Override
    public List<Book> getBooksByAuthorId(int id) {
        return bookRepository.findByAuthorId(id);
    }

    @Override
    public List<Book> getBooksByIds(List<Integer> ids) {
        List<Book> bookResult = new ArrayList<>();
        for (int id : ids) {
            Optional<Book> optionalBook = getBookById(id);
            optionalBook.ifPresent(bookResult::add);
        }
        return bookResult;
    }

    @Override
    public Optional<Integer> findAuthorIdByDetails(String name, String nationality, LocalDate birthDate) {
        return authorRepository.findIdByNameAndNationalityAndBirthDate(name, nationality, birthDate);
    }

    @Override
    public int addAuthor(String name, String nationality, LocalDate birthDate) {
        Author author = new Author(name, nationality, birthDate);
        authorRepository.save(author);
        return author.getId();
    }

    @Override
    public Optional<Integer> findPublisherIdByDetails(String name, String location) {
        return publisherRepository.findIdByNameAndLocation(name, location);
    }

    @Override
    public int addPublisher(String name, String location) {
        Publisher publisher = new Publisher(name, location);
        publisherRepository.save(publisher);
        return publisher.getId();
    }

    @Override
    public List<Book> getBooksByGenreId(int genresId){
        List<Integer> bookIds = bookGenreRelationshipRepository.findBookIdByGenresId(genresId);
        return bookRepository.findAllById(bookIds);

    }
}
