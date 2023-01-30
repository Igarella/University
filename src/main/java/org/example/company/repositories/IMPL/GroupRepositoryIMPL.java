package org.example.company.repositories.IMPL;

import org.example.company.DTO.Group;
import org.example.company.repositories.GroupRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupRepositoryIMPL implements GroupRepository {
    @Override
    public List<Group> getAllGroups() {
        List<Group> groupList = new ArrayList<>();
        try {
            File file = new File("resources/Groups.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] groupFields = line.split(",");
                Group group = new Group(UUID.fromString(groupFields[0]), UUID.fromString(groupFields[1]), groupFields[2], UUID.fromString(groupFields[3]));
                groupList.add(group);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return groupList;
    }

    @Override
    public void addStudentToGroupBYStudentId(UUID studentId) {

    }

    @Override
    public Group getGroupById(UUID groupId) {
        return getAllGroups()
                .stream()
                .filter(e -> e.getGroupId().equals(groupId))
                .findFirst()
                .get();
    }
}
