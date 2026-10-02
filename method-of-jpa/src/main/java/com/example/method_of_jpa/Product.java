package com.example.method_of_jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Entity
@NoArgsConstructor
@AllArgsConstructor   
@Builder 
public class Product {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  int productId ;

    private  String productName ;

    private  String productBrand;
    
    private  double productPrice;

    private  int quantity ;
}
