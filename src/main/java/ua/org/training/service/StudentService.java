package ua.org.training.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.org.training.exception.StudentNotFoundException;
import ua.org.training.model.Student;

import java.util.List;

public interface StudentService {
    Student update(Student student);

    Student save(Student student);

    Student findById(Long studentId) throws StudentNotFoundException;

    void deleteById(Long studentId);

    Page<Student> findAll(Pageable pageable);

    List<Student> findAllByGroupId(Long groupId);

    void deleteStudentsFromList(List<Student> studentsList);

    void saveAll(List<Student> studentsList);
}