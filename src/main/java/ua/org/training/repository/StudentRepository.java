package ua.org.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.org.training.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findAllByGroupId(Long groupId, Pageable pageable);
}
