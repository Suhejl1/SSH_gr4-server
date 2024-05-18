package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Faq;
import com.sshproject.bookstore.Repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FaqService implements FaqServiceInterface {

    @Autowired
    private FaqRepository faqRepository;

    @Override
    public List<Faq> getFaqs() {
        return faqRepository.findAll();
    }

    @Override
    public int addFaq(Faq faq) {
        return faqRepository.save(faq).getId();
    }

    @Override
    public boolean updateFaqAnswer(int id, String answer) {
        Faq faq = faqRepository.findById(id).orElse(null);
        if (faq != null) {
            faq.setAnswer(answer);
            faqRepository.save(faq);
            return true;
        }
        return false;
    }
}
