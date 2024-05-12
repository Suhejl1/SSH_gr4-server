package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.UserPaymentMethod;
import com.sshproject.bookstore.Service.UserPaymentMethodServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserPaymentMethodController {

    @Autowired
    private UserPaymentMethodServiceInterface userPaymentMethodService;

    @GetMapping("/api/v1/userpaymentmethods")
    public ResponseEntity<List<UserPaymentMethod>> getAllUserPaymentMethods() {
        List<UserPaymentMethod> userPaymentMethods = userPaymentMethodService.getAllUserPaymentMethods();
        if (userPaymentMethods.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(userPaymentMethods);
        }
    }

    @PostMapping("/api/v1/userpaymentmethods")
    public ResponseEntity<Integer> addUserPaymentMethod(@RequestBody UserPaymentMethod userPaymentMethod) {
        int id = userPaymentMethodService.addUserPaymentMethod(userPaymentMethod);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @DeleteMapping("/api/v1/userpaymentmethods/{userPaymentMethodId}")
    public ResponseEntity<Void> deleteUserPaymentMethod(@PathVariable int userPaymentMethodId) {
        boolean deleted = userPaymentMethodService.deleteUserPaymentMethod(userPaymentMethodId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
