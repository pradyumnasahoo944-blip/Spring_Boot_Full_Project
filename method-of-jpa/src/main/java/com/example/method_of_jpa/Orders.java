package com.example.method_of_jpa;

import org.springframework.data.repository.cdi.Eager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Builder 

public class Orders {
    @Id 
    @GeneratedValue (strategy = GenerationType.UUID)
  private  String orderId;

  private  int productId;

  private int quantity;

  private double totalPrice ;
    
}
