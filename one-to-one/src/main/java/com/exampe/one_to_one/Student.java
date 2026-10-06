package com.exampe.one_to_one;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentRoll;

    private String studentName;

    private String studentEmail;

//    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})//for casade way
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)//fetch = FetchType.LAZY mean foreeign key is not shown
    @JoinColumn(name = "adress_id")
    private Adress adress;
}
