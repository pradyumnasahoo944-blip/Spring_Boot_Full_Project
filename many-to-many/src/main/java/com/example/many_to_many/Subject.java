package com.example.many_to_many;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder

public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;
    private  String subjectName;

    @ManyToMany(mappedBy = "subjects",fetch = FetchType.EAGER)
    private List<Student> students;
}
