package ge.example.university.university.controller;


import ge.example.university.university.model.UnionAll;
import ge.example.university.university.service.UnionAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unionAll")
public class UnionAllController {
    UnionAllService unionAllService;

    @Autowired
    UnionAllController(UnionAllService unionAllService) {
        this.unionAllService = unionAllService;
    }

}
