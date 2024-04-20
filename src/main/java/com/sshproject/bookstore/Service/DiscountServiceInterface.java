package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Discount;

public interface DiscountServiceInterface {

    int addDiscount(Discount discount);

    Discount getByCode(String code);

}
