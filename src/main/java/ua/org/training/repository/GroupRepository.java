package ua.org.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.org.training.model.Group;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findById(Long id);
}
