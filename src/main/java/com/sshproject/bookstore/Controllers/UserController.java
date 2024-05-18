package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.User;
import com.sshproject.bookstore.Service.UserService;
import com.sshproject.bookstore.Service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserServiceInterface userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        int deletedId = userService.deleteUser(id);
        if (deletedId != 0) {
            return ResponseEntity.ok("User deleted successfully with id " + deletedId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @GetMapping("/users/byEmail/{email}")
    public ResponseEntity<Integer> getUserIdByEmail(@PathVariable String email) {
        Optional<User> userOptional = userService.findUserByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(user.getId());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
