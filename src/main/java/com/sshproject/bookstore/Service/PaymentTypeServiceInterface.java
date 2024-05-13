package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.PaymentType;

import java.util.List;

public interface PaymentTypeServiceInterface {
    List<PaymentType> getAllPaymentTypes();
    int addPaymentType(PaymentType paymentType);
    boolean deletePaymentType(int paymentTypeId);
}
