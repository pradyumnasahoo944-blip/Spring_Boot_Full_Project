package com.jt.expense_tracker;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity //IT IS A OBJRCT CTRESTE BY HIBERNATE TO CREATE  TABLE BASED ON INTSNCE VARIAVLE
public class Expense {
    @Id //it use to make the id as primary key
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //Let the database generate the ID automatically, usually using an auto-increment/identity column.
    private int id ;
    private String  title ;
    private String  category ;
    private double  price ;
    private LocalDate date ;

    


}