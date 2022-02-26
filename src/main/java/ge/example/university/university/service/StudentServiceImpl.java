package ge.example.university.university.service;


import ge.example.university.university.model.Student;
import ge.example.university.university.repository.jpa.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Autowired
    StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }


    @Override
    public Student getStudent(Integer id) {
        return studentRepository.getById(id);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> filter(Integer id, String firstName, String lastName, String personalNo, String email) {
        return studentRepository.
                findAll(

                        ((root, query, cb) ->{
                            Predicate predicate = cb.conjunction();
                            if(id!=null){
                                predicate=cb.and(predicate,cb.equal(root.get("id"),id));
                            }
                            if(firstName!=null){
                                predicate=cb.and(predicate,cb.like(root.get("firstName"),firstName));
                            }
                            if(lastName!=null){
                                predicate=cb.and(predicate,cb.like(root.get("lastName"),lastName));
                            }
                            if(personalNo!=null){
                                predicate=cb.and(predicate,cb.like(root.get("personalNo"),personalNo));
                            }
                            if(email!=null){
                                predicate=cb.and(predicate,cb.like(root.get("email"),email));
                            }
                            return predicate;
                        }));
    }

    @Override
    public void deleteStudent(Integer id) {

    }

}
