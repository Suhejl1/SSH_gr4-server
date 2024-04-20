package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Faq;
import com.sshproject.bookstore.Repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService implements FaqServiceInterface{

    @Autowired
    private FaqRepository faqRepository;

    @Override
    public List<Faq> getFaqs() {
        List<Faq> allFaqs = faqRepository.findAll();
        return allFaqs;
    }

    @Override
    public int addFaq(Faq faq) {
        Faq newFaq = new Faq(faq.getQuestion(),faq.getAnswer());
        faqRepository.save(newFaq);
        return newFaq.getId();
    }
}
