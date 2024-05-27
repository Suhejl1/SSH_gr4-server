package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.DTO.CartItemDTO;
import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.Cart;
import com.sshproject.bookstore.Repository.BookRepository;
import com.sshproject.bookstore.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements CartServiceInterface {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookRepository bookRepository;


    @Override

    public List<CartItemDTO> getAllCartItems(int userId) {
        List<Cart> cartItems = cartRepository.findByCartId(userId);

        List<CartItemDTO> books = new ArrayList<>();
        for(Cart cart : cartItems) {
            Book book = bookRepository.findById(cart.getProductItemId()).orElse(null);

            if(book != null) {
                CartItemDTO newItem = new CartItemDTO(book.getTitle(), book.getImage(), cart.getQuantity(), book.getId(), book.getPrice());
                books.add(newItem);
            }

        }
            return books;
    }

    @Override
    public int addToCart(Cart cart) {

        Optional<Cart> newCart = cartRepository.findByCartIdAndProductItemId(cart.getCartId(), cart.getProductItemId());
        if(newCart.isPresent()) {
            Cart cartItem = newCart.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartRepository.save(cartItem);
            return cartItem.getId();
        }
        Cart newCartItem = new Cart(cart.getCartId(), cart.getProductItemId(), cart.getQuantity());

        cartRepository.save(newCartItem);
        return newCartItem.getId();
    }

    @Override
    public void deleteFromCart(int userId, int bookId) {
        cartRepository.deleteByUserIdAndBookId(userId, bookId);
    }

    @Override
    public void clearCart(int userId) {
        cartRepository.deleteByUserId(userId);
    }

    @Override
    public void deleteFromCart(int cartItemId, int bookId) {
        Optional<Cart> cartItemOptional = cartRepository.findByCartIdAndProductItemId(cartItemId, bookId);
        cartItemOptional.ifPresent(cartRepository::delete);
    }

    @Transactional
    @Override
    public void deleteAllItemsFromCart(int userId) {
        cartRepository.deleteByCartId(userId);
    }

    @Override
    @Transactional
    public void updateCartItem(int userId, int bookId, int newQuantity) {
        System.out.println("This is the update function in the service");
        Optional<Cart> oldCartItem = cartRepository.findByCartIdAndProductItemId(userId, bookId);
        if(oldCartItem.isPresent() && oldCartItem.get().getQuantity() - newQuantity < 0) {
            incrementQuantity(userId, bookId);
        }else {
            decrementQuantity(userId, bookId);
        }
    }


    @Override
    @Transactional
    public void incrementQuantity(int userId, int bookId) {
        System.out.println("This is the increment function in the service");
        Optional<Cart> cartItemOptional = cartRepository.findByCartIdAndProductItemId(userId, bookId);
        if (cartItemOptional.isPresent()) {
            Cart cartItem = cartItemOptional.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartRepository.save(cartItem);
        }
    }

    @Override
    @Transactional
    public void decrementQuantity(int userId, int bookId) {
        System.out.println("This is the decrement fucntnion in the service");
        Optional<Cart> cartItemOptional = cartRepository.findByCartIdAndProductItemId(userId, bookId);
        if (cartItemOptional.isPresent()) {
            Cart cartItem = cartItemOptional.get();
            if (cartItem.getQuantity() > 1) {
                cartItem.setQuantity(cartItem.getQuantity() - 1);
                cartRepository.save(cartItem);
            } else {
                cartRepository.delete(cartItem);
            }
        }
    }

}
