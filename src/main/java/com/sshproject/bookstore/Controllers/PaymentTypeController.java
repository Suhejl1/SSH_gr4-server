package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.PaymentType;
import com.sshproject.bookstore.Service.PaymentTypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentTypeController {

    @Autowired
    private PaymentTypeServiceInterface paymentTypeService;

    @GetMapping("api/V1/payment_type")
    public ResponseEntity<List<PaymentType>> getAllPaymentTypes() {
        List<PaymentType> paymentTypes = paymentTypeService.getAllPaymentTypes();
        if (paymentTypes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(paymentTypes);
        }
    }

    @PostMapping("api/V1/payment_type")
    public ResponseEntity<?> addPaymentType(@RequestBody PaymentType paymentType) {
        int id = paymentTypeService.addPaymentType(paymentType);
        if (id != 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("api/V1/payment_type/{paymentTypeId}")
    public ResponseEntity<?> deletePaymentType(@PathVariable int paymentTypeId) {
        boolean deleted = paymentTypeService.deletePaymentType(paymentTypeId);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
