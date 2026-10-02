package com.example.method_of_jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,String>{
    
}
