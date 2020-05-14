package ua.org.training.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.org.training.exception.GroupNotFoundException;
import ua.org.training.model.Group;
import ua.org.training.repository.GroupRepository;

import javax.transaction.Transactional;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final StudentService studentService;

    public GroupServiceImpl(GroupRepository groupRepository,
                            StudentService studentService) {
        this.groupRepository = groupRepository;
        this.studentService = studentService;
    }

    @Transactional
    @Override
    public Group update(Group group) {
        studentService.deleteStudentsFromList(group.getStudentsList());
        Group groupToReturn = groupRepository.save(group);
        studentService.saveAll(group.getStudentsList());
        groupToReturn.setStudentsList(group.getStudentsList());
        return groupToReturn;
    }

    @Transactional
    @Override
    public Group save(Group group) {
        Group groupToReturn = groupRepository.save(group);
        studentService.saveAll(group.getStudentsList());
        groupToReturn.setStudentsList(group.getStudentsList());
        return groupToReturn;
    }

    @Override
    public Group findById(Long groupId) throws GroupNotFoundException{
        Group groupToReturn = groupRepository.findById(groupId).orElseThrow(GroupNotFoundException::new);
        groupToReturn.setStudentsList(studentService.findAllByGroupId(groupToReturn.getId()));
        return groupToReturn;
    }

    @Transactional
    @Override
    public void deleteById(Long groupId) {
        Group group = findById(groupId);
        studentService.deleteStudentsFromList(group.getStudentsList());
        groupRepository.deleteById(groupId);
    }

    @Override
    public Page<Group> findAll(Pageable pageable) {
        Page<Group> groupPage = groupRepository.findAll(pageable);
        groupPage.forEach(group -> {
            group.setStudentsList(studentService.findAllByGroupId(group.getId()));
        });
        return groupPage;
    }
}
