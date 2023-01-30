package org.example.company.services;

import org.example.company.DTO.Phone;

import java.util.List;
import java.util.UUID;

public interface PhoneService {
    List<Phone> getAllPhones();

    void writePhones(List<Phone> list);

    void addPhone(Phone phone);

    void deletePhone(UUID uuid);
}
