package ua.org.training.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.org.training.exception.GroupNotFoundException;
import ua.org.training.model.Group;

public interface GroupService {
    Group update(Group group);

    Group save(Group group);

    Group findById(Long groupId) throws GroupNotFoundException;

    void deleteById(Long groupId);

    Page<Group> findAll(Pageable pageable);
}
