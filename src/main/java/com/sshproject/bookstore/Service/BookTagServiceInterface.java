package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.BookTag;

import java.util.List;

public interface BookTagServiceInterface {
    int addBookTag(BookTag bookTag);

    List<Book> getBooksByTag(String tag);

}
