package org.example.company.repositories;

import org.example.company.DTO.Email;
import org.example.company.DTO.Phone;

import java.util.List;
import java.util.UUID;

public interface EmailRepository {
    List<Email> getAllEmails();

    void writeEmails(List<Email> list);

    void addEmail(Email email);

    void deleteEmail(UUID uuid);

    List<Email> getEmailByStudentId(UUID id);
}
