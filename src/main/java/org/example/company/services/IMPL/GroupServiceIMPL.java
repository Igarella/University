package org.example.company.services.IMPL;

import org.example.company.DTO.Group;
import org.example.company.repositories.GroupRepository;
import org.example.company.repositories.IMPL.GroupRepositoryIMPL;
import org.example.company.services.GroupService;

import java.util.List;
import java.util.UUID;

public class GroupServiceIMPL implements GroupService {
    @Override
    public List<Group> getAllGroups() {
        GroupRepository repository = new GroupRepositoryIMPL();
        return repository.getAllGroups();
    }

    @Override
    public void addGroup(Group group) {
        GroupRepository repository = new GroupRepositoryIMPL();
        repository.addGroup(group);
    }

    @Override
    public void addStudentToGroupBYStudentId(UUID studentId) {
        GroupRepository repository = new GroupRepositoryIMPL();
        repository.addStudentToGroupBYStudentId(studentId);
    }

    @Override
    public Group getGroupById(UUID groupId) {
        GroupRepository repository = new GroupRepositoryIMPL();
        return repository.getGroupById(groupId);
    }

}
