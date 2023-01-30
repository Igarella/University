package org.example.company.repositories.IMPL;

import org.example.company.DTO.Email;
import org.example.company.repositories.EmailRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmailRepositoryIMPL implements EmailRepository {

    @Override
    public List<Email> getAllEmails() {
        List<Email> emailList = new ArrayList<>();
        try {
            File file = new File("resources/Emails.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] emailFields = line.split(",");
                Email email = new Email(UUID.fromString(emailFields[0]), emailFields[1], UUID.fromString(emailFields[2]));
                emailList.add(email);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emailList;
    }

    @Override
    public void writeEmails(List<Email> list) {

    }

    @Override
    public void addEmail(Email email) {
        try {
            FileWriter writer = new FileWriter("resources/Emails.txt",true);
            writer.write(email.getId() + "," + email.getEmail() + "," + email.getStudentId() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmail(UUID uuid) {

    }

    @Override
    public List<Email> getEmailByStudentId(UUID id) {
        return getAllEmails()
                .stream()
                .filter(e -> e.getStudentId().equals(id))
                .collect(Collectors.toList());
    }
}
