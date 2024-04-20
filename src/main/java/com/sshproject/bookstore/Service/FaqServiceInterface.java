package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Faq;

import java.util.List;

public interface FaqServiceInterface {
    List<Faq> getFaqs();

    int addFaq(Faq faq);
}
