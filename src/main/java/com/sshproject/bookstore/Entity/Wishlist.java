package com.sshproject.bookstore.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "wishlist")
public class Wishlist {

  public Wishlist(int bookId, int userId) {
      this.bookId = bookId;
      this.userId = userId;

  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int bookId;
  private int userId;



}
