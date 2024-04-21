package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.BookTag;
import com.sshproject.bookstore.Repository.BookTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookTagService implements BookTagServiceInterface{
    @Autowired
    private BookTagRepository bookTagRepository;

    @Autowired
    private BookServiceInterface bookService;

    @Override
    public int addBookTag(BookTag bookTag) {
        BookTag newBookTag = new BookTag(bookTag.getBookId(), bookTag.getTagName());
        bookTagRepository.save(newBookTag);
        return newBookTag.getId();
    }

    @Override
    public List<Book> getBooksByTag(String tag) {
        List<Integer> bookIds = new ArrayList<>();
        List<BookTag> bookTags = bookTagRepository.findByTagName(tag);
        for(BookTag bt : bookTags){
            bookIds.add(bt.getBookId());
        }
        List<Book> bookResultList = bookService.getBooksByIds(bookIds);
        return bookResultList;
    }
}
