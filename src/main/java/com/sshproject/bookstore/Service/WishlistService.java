package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.Wishlist;
import com.sshproject.bookstore.Repository.BookRepository;
import com.sshproject.bookstore.Repository.WishlistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService implements  WishlistServiceInterface{

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private BookRepository bookRepository;

    //TODO: You can add the same book twice to the same user id , this should not happen.
    @Override
    public void addBookToWishlist(int bookId, int userId) {
        boolean bookExists = wishlistRepository.existsByBookIdAndUserId(bookId, userId);
        if (bookExists) {
            // Book already exists in the wishlist, return without adding it again
            return;
        }

        // Book doesn't exist in the wishlist, add it
        Wishlist newItem = new Wishlist(bookId, userId);
        wishlistRepository.save(newItem);
    }
    @Transactional
    @Override
    public void removeBookFromWishlist(int bookId, int userId) {
        wishlistRepository.deleteByBookIdAndUserId(bookId, userId);
    }

    @Override
    public List<Book> getBooksFromWishlist(int userId) {
            List<Wishlist> wishlistItems = wishlistRepository.findByUserId(userId);

            List<Book> books = new ArrayList<>();
            for (Wishlist item : wishlistItems) {
                Book book = bookRepository.findById(item.getBookId()).orElse(null);
                if (book != null) {
                    books.add(book);
                }
            }
            return books;
        }


    @Override
    public boolean checkBookOnWishlist(int bookId, int userId) {
        return wishlistRepository.existsByBookIdAndUserId(bookId, userId);
    }

    @Transactional
    @Override
    public void clearWishlist(int userId) {
        wishlistRepository.deleteByUserId(userId);
    }
}
