package org.example.company.services.IMPL;

import org.example.company.DTO.Email;
import org.example.company.repositories.EmailRepository;
import org.example.company.repositories.IMPL.EmailRepositoryIMPL;
import org.example.company.services.EmailService;

import java.util.List;
import java.util.UUID;

public class EmailServiceIMPL implements EmailService {
    @Override
    public List<Email> getAllEmails() {
        EmailRepository repository = new EmailRepositoryIMPL();
        return repository.getAllEmails();
    }

    @Override
    public void writeEmails(List<Email> list) {
        EmailRepository repository = new EmailRepositoryIMPL();
        repository.writeEmails(list);
    }

    @Override
    public void addEmail(Email email) {
        EmailRepository repository = new EmailRepositoryIMPL();
        repository.addEmail(email);
    }

    @Override
    public void deleteEmail(UUID uuid) {
        EmailRepository repository = new EmailRepositoryIMPL();
        repository.deleteEmail(uuid);
    }
}
