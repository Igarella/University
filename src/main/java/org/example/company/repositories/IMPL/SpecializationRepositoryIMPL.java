package org.example.company.repositories.IMPL;

import org.example.company.DTO.Group;
import org.example.company.DTO.Specialization;
import org.example.company.DTO.Specialization;
import org.example.company.repositories.SpecializationRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SpecializationRepositoryIMPL implements SpecializationRepository {
    
    @Override
    public List<Specialization> getAllSpecializations() {
        List<Specialization> specializationList = new ArrayList<>();
        try {
            File file = new File("resources/Specializations.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] specializationFields = line.split(",");
                Specialization specialization = new Specialization(UUID.fromString(specializationFields[0]), specializationFields[1]);
                specializationList.add(specialization);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return specializationList;
    }

    @Override
    public void addSpecialization(Specialization specialization) {
        try {
            FileWriter writer = new FileWriter("resources/Specializations.txt",true);
            writer.write(specialization.getSpecializationId() + ","
                    + specialization.getSpecializationName() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Specialization getSpecializationById(UUID specializationId) {
        return getAllSpecializations()
                .stream()
                .filter(e -> e.getSpecializationId().equals(specializationId))
                .findFirst()
                .get();
    }


}
