package ua.org.training.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.org.training.exception.StudentNotFoundException;
import ua.org.training.model.Student;
import ua.org.training.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId).orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> findAllByGroupId(Long groupId, Pageable pageable) {
        return studentRepository.findAllByGroupId(groupId, pageable);
    }

    @Override
    public void deleteStudentsFromList(List<Student> studentsList) {

    }

    @Override
    public void saveAll(List<Student> studentsList) {
        if (studentsList != null) {
            for (Student student : studentsList) {
                save(student);
            }
        }
    }
}
