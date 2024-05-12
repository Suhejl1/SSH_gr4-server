package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.Wishlist;
import com.sshproject.bookstore.Repository.BookRepository;
import com.sshproject.bookstore.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class WishlistService implements  WishlistServiceInterface{

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private BookRepository bookRepository;
    @Override
    public void addBookToWishlist(int bookId, int userId) {
        Wishlist newItem = new Wishlist(bookId, userId);
        wishlistRepository.save(newItem);

    }

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

    @Override
    public void clearWishlist(int userId) {
        wishlistRepository.deleteByUserId(userId);
    }
}
