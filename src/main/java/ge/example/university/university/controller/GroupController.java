package ge.example.university.university.controller;


import ge.example.university.university.model.Group;
import ge.example.university.university.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("group")
@CrossOrigin("http://localhost:3002/")
public class GroupController {
    GroupService groupService;

    @Autowired
    GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> filter(@RequestParam(required = false) Integer id, @RequestParam(required = false) String title, @RequestParam(required = false) Integer groupNo) {
        return groupService.filter(id, title, groupNo);
    }


    @PostMapping
    public Group addGroup(@RequestBody Group group) {

        return groupService.addGroup(group);
    }

    @GetMapping("{id}")
    public Group getGroup(@PathVariable Integer id) {
        return groupService.getGroup(id);
    }

    @DeleteMapping("{id}")
    public void deleteGroup(@PathVariable Integer id) {
        groupService.deleteGroup(id);
    }
}
