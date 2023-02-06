package org.example.company.services.IMPL;

import org.example.company.DTO.Phone;
import org.example.company.repositories.IMPL.PhoneRepositoryIMPL;
import org.example.company.repositories.PhonesRepository;
import org.example.company.services.PhoneService;

import java.util.List;
import java.util.UUID;

public class PhoneServiceIMPL implements PhoneService {
    @Override
    public List<Phone> getAllPhones() {
        PhonesRepository repository = new PhoneRepositoryIMPL();
        return repository.getAllPhones();
    }

    @Override
    public void addPhone(Phone phone) {
        PhonesRepository repository = new PhoneRepositoryIMPL();
        repository.addPhone(phone);
    }

    @Override
    public void deletePhone(UUID uuid) {
        PhonesRepository repository = new PhoneRepositoryIMPL();
        repository.deletePhone(uuid);
    }
}
