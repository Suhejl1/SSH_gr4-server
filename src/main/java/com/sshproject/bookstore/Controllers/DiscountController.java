package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Discount;
import com.sshproject.bookstore.Service.DiscountService;
import com.sshproject.bookstore.Service.DiscountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiscountController {
    @Autowired
    private DiscountServiceInterface discountInterface;

    @PostMapping("api/v1/discount")
    public int addDiscount(@RequestBody Discount discount){
        int new_discount_res = discountInterface.addDiscount(discount);
        return new_discount_res;
    }

    @GetMapping("api/v1/discount/{code}")
    public Discount getDiscountByCode(@PathVariable("code") String code){
        Discount active_discount = discountInterface.getByCode(code);
        return active_discount;
    }

}
