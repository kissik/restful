package ua.org.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.org.training.exception.StudentNotFoundException;
import ua.org.training.model.Student;
import ua.org.training.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/id/{id}", produces = "application/json")
    public Student getStudent(@PathVariable Long id) throws StudentNotFoundException {
        return studentService.findById(id);
    }

    @GetMapping(params = {"page", "size"}, produces = "application/json")
    public Page<Student> getStudentPage(Pageable pageable) {
        return studentService.findAll(pageable);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {
        Student oldStudent = studentService.findById(id);
        student.setId(id);
        return studentService.update(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
