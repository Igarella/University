package org.example.company.services;

import org.example.company.DTO.Email;
import org.example.company.DTO.Phone;

import java.util.List;
import java.util.UUID;

public interface EmailService {
    List<Email> getAllEmails();

    void writeEmails(List<Email> list);

    void addEmail(Email email);

    void deleteEmail(UUID uuid);
}
