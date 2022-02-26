package ge.example.university.university.service;

import ge.example.university.university.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    Teacher getTeacher(Integer id);

    Teacher addTeacher(Teacher teacher);

    List<Teacher> filter(Integer id, String firstName, String lastName, String personalNo, String email);


    void deleteTeacher(Integer id);
}
