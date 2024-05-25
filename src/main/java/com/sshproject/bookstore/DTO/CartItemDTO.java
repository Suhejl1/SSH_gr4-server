package com.sshproject.bookstore.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDTO {

    public CartItemDTO(String title, String image, int quantity, int id, double price) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }

    private int id;
    private String title;
    private String image;
    private int quantity;
    private double price;
}
