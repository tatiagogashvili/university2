package ge.example.university.university.service;

import ge.example.university.university.model.Teacher;
import ge.example.university.university.repository.jpa.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    TeacherRepository teacherRepository;

    @Autowired
    TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository=teacherRepository;
    }

    @Override
    public Teacher getTeacher(Integer id) {
        return teacherRepository.getById(id);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> filter(Integer id, String firstName, String lastName, String personalNo, String email) {
        return teacherRepository.
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
    public void deleteTeacher(Integer id) {

    }
}
