package ge.example.university.university.controller;


import ge.example.university.university.model.Teacher;
import ge.example.university.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
@CrossOrigin("http://localhost:3002/")
public class TeacherController {
    TeacherService teacherService;

    @Autowired
    TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> filter(@RequestParam(required = false) Integer id, @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName, @RequestParam(required = false) String personalNo, @RequestParam(required = false) String email) {
        return teacherService.filter(id, firstName, lastName, personalNo, email);
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @GetMapping("{id}")
    public Teacher getTeacher(@PathVariable Integer id) {
        return teacherService.getTeacher(id);
    }

    @DeleteMapping("{id}")
    public void deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
    }
}
