package com.example.jpa_annotation_concept;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Table(name = "emp") 
@Builder ///it provide a flexible constructer
public class Employee {
    @Id 
    @GeneratedValue (strategy =GenerationType.UUID)
    @Column (name = "emp_id")
    private  String id;


    @Column (name = "emp_name",columnDefinition = "VARCHAR(30)",nullable = false,unique = true)
    private String name ;


    @Transient //it cannot participate on database 
    @Column (name = "emp_desc")
    @Lob //string value generated in tiny text   //if in bytrre form then i use BLOB //if char then i use CLOB
    private String description ;


    @Column (name = "emp_salary",precision = 10 ,scale = 2)//scale means how manyt degit we store aftter point
    private BigDecimal salary;

    @Column (name = "emp_status")
    @Enumerated (EnumType.STRING)
    private EmployeStatus status;

    @CreationTimestamp 
    private LocalDateTime createdDateTime;

    @UpdateTimestamp 
    private LocalDateTime updatedDateTime;

}
