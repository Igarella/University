package org.example.company.repositories;

import org.example.company.DTO.Group;

import java.util.List;
import java.util.UUID;

public interface GroupRepository {
    List<Group> getAllGroups();

    void addStudentToGroupBYStudentId(UUID studentId);

    Group getGroupById(UUID groupId);

    void addGroup(Group group);

}
