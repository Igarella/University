package org.example.company.JPARepository;

import org.example.company.DTO.Student;
import org.example.company.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepositoryJPA extends JpaRepository<StudentEntity, UUID> {

}
