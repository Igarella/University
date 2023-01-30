package org.example.company.repositories.IMPL;

import org.example.company.DTO.Phone;
import org.example.company.repositories.PhonesRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PhoneRepositoryIMPL implements PhonesRepository {

    @Override
    public void writePhones(List<Phone> list) {

    }

    @Override
    public void addPhone(Phone phone) {
        try {
            FileWriter writer = new FileWriter("resources/Phones.txt",true);
            writer.write(phone.getId() + "," + phone.getPrefixCountry() + "," + phone.getNumberPhone() + ","
                    + phone.getTypePhone() + "," + phone.getStudentId() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePhone(UUID uuid) {

    }

    @Override
    public List<Phone> getPhoneByStudentId(UUID studentId) {
        List<Phone> phoneList = getAllPhones();
        return phoneList
                .stream()
                .filter(e -> e.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Phone> getAllPhones() {
        List<Phone> phoneList = new ArrayList<>();
        try {
            File file = new File("resources/Phones.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] phones = line.split(",");
                Phone phone = new Phone(UUID.fromString(phones[0]), Integer.parseInt(phones[1]), phones[2], phones[3], UUID.fromString(phones[4]));
                phoneList.add(phone);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phoneList;
    }
}
