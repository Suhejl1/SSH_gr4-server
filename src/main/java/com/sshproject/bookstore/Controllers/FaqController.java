package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Faq;
import com.sshproject.bookstore.Service.FaqServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FaqController {
    @Autowired
    private FaqServiceInterface faqInterface;

    @GetMapping("api/v1/faq")
    public List<Faq> getAllFaqs(){
        List<Faq> faqs =  faqInterface.getFaqs();
        return faqs;
    }

    @PostMapping("api/v1/faq")
    public int addFaq(@RequestBody Faq faq){
        int new_faq_id = faqInterface.addFaq(faq);
        return new_faq_id;
    }

}
