package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    List<Favorite> findByBookId(int bookId);
}
