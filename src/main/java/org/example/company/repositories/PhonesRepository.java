package org.example.company.repositories;

import org.example.company.DTO.Phone;
import org.example.company.DTO.Student;

import java.io.IOException;
import java.lang.invoke.CallSite;
import java.util.List;
import java.util.UUID;

public interface PhonesRepository {

    List<Phone> getAllPhones();

    void writePhones(List<Phone> list);

    void addPhone(Phone phone);

    void deletePhone(UUID uuid);

    List<Phone> getPhoneByStudentId(UUID id);

//    void addPhoneByStudentId(UUID studentId);
}
