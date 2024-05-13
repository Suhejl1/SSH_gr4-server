package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.PaymentType;
import com.sshproject.bookstore.Repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentTypeService implements PaymentTypeServiceInterface {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Override
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public int addPaymentType(PaymentType paymentType) {
        PaymentType newPaymentType = paymentTypeRepository.save(paymentType);
        return newPaymentType.getId();
    }

    @Transactional
    @Override
    public boolean deletePaymentType(int paymentTypeId) {
        Optional<PaymentType> paymentTypeOptional = paymentTypeRepository.findById(paymentTypeId);
        if (paymentTypeOptional.isPresent()) {
            paymentTypeRepository.delete(paymentTypeOptional.get());
            return true;
        } else {
            return false;
        }
    }

}
