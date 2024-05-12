package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Book;

import java.util.List;

public interface WishlistServiceInterface {

    void addBookToWishlist (int bookId, int userId);

    void removeBookFromWishlist(int bookId, int userId);

    List<Book> getBooksFromWishlist(int userId);

    boolean checkBookOnWishlist(int bookId, int userId);

    void clearWishlist(int userId);

}
