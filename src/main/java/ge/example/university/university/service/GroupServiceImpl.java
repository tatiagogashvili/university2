package ge.example.university.university.service;


import ge.example.university.university.model.Group;
import ge.example.university.university.repository.jpa.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    GroupRepository groupRepository;

    @Autowired
    GroupServiceImpl(GroupRepository groupRepository){
        this.groupRepository=groupRepository;
    }

    @Override
    public Group getGroup(Integer id) {
        return groupRepository.getById(id);
    }

    @Override
    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Group> filter(Integer id, String title, Integer groupNo) {
        System.out.print(id);
        return groupRepository.
                findAll(

                        ((root, query, cb) ->{
                            Predicate predicate = cb.conjunction();
                            if(id!=null){
                                predicate=cb.and(predicate,cb.equal(root.get("id"),id));
                            }
                            if(title!=null){
                                predicate=cb.and(predicate,cb.like(root.get("title"),title.concat("%")));
                            }
                            if(groupNo!=null){
                                predicate=cb.and(predicate,cb.equal(root.get("groupNo"),groupNo));
                            }

                            return predicate;
                        })
                );
    }

    @Override
    public void deleteGroup(Integer id) {

    }
}
