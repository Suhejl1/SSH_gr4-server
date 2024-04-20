package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.BookTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookTagRepository extends JpaRepository<BookTag,Integer> {
    List<BookTag> findByTagName(String tag_name);

}
