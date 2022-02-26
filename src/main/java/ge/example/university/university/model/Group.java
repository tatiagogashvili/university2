package ge.example.university.university.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "group")
public class Group {
    @Id
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "group_no")
    private Integer groupNo;
}
