package ge.example.university.university.service;


import ge.example.university.university.model.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {

    Group getGroup(Integer id);

    Group addGroup(Group group);

    List<Group> filter(Integer id, String title, Integer groupNo);

    void deleteGroup(Integer id);
}
