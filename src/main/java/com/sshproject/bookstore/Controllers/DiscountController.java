package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Discount;
import com.sshproject.bookstore.Service.DiscountService;
import com.sshproject.bookstore.Service.DiscountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiscountController {
    @Autowired
    private DiscountServiceInterface discountInterface;

    @PostMapping("api/v1/discount")
    public ResponseEntity<String> addDiscount(@RequestBody Discount discount) {
        int new_discount_res = discountInterface.addDiscount(discount);
        if (new_discount_res > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Discount added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add discount");
        }
    }

    @GetMapping("api/v1/discount/{code}")
    public ResponseEntity<Discount> getDiscountByCode(@PathVariable("code") String code) {
        Discount active_discount = discountInterface.getByCode(code);
        if (active_discount != null) {
            return ResponseEntity.ok(active_discount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
