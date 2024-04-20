package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Discount;
import com.sshproject.bookstore.Repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService implements DiscountServiceInterface{

    @Autowired
    private DiscountRepository discountRepository;
    @Override
    public int addDiscount(Discount discount) {
        Discount new_discount = new Discount(discount.getDiscountCode(),discount.getDiscount_percentage(),discount.getExpire_date());
        discountRepository.save(new_discount);
        return new_discount.getId();
    }

    @Override
    public Discount getByCode(String code) {
        Discount active_discount = discountRepository.findByDiscountCode(code);
        return active_discount;
    }
}
