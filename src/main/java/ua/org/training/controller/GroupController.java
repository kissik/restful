package ua.org.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.org.training.exception.GroupNotFoundException;
import ua.org.training.model.Group;
import ua.org.training.service.GroupService;

@RestController
@RequestMapping("api/groups")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = "/id/{id}", produces = "application/json")
    public Group getGroup(@PathVariable Long id) throws GroupNotFoundException {
        return groupService.findById(id);
    }

    @GetMapping(value = "/all", params = {"page", "size"}, produces = "application/json")
    public Page<Group> getStudentPage(Pageable pageable) {
        return groupService.findAll(pageable);
    }

    @PostMapping
    public Group addGroup(@RequestParam Group group) {
        return groupService.save(group);
    }

    @PutMapping
    public Group updateGroup(@PathVariable Long id,
                                 @RequestParam Group group) {
        group.setId(id);
        return groupService.update(group);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        groupService.deleteById(id);
    }
}
