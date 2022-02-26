package ge.example.university.university.model;

import lombok.Data;

import javax.persistence.*;

@SequenceGenerator(sequenceName = "distribution_id_seq", name = "example",allocationSize = 1)
@Entity
@Data
@Table(name = "union_all")
public class UnionAll {
    @Id
    @GeneratedValue(generator = "example",strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "teacher_id")
    private Integer teacherId;
}
