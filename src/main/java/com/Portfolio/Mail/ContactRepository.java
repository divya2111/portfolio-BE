package com.Portfolio.Mail;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Portfolio.Mail.ContactRequest;

public interface ContactRepository extends JpaRepository<ContactRequest, Long> {
}
