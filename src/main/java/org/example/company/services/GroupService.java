package org.example.company.services;

import org.example.company.DTO.Group;

import java.util.List;
import java.util.UUID;

public interface GroupService {
    List<Group> getAllGroups();

    void addGroup(Group group);

    Group getGroupById(UUID groupId);
}
