package com.exampe.one_to_one;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adressId;

    private String city;

    private  String state ;

    private  String country ;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "adress")
    private Student student;
}
