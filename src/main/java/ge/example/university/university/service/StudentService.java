package ge.example.university.university.service;


import ge.example.university.university.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Student getStudent(Integer id);

    Student addStudent(Student student);

    List<Student> filter(Integer id, String firstName, String lastName, String personalNo, String email);


    void deleteStudent(Integer id);
}
