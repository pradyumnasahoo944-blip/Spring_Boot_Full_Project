package com.jt.hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


public class Student {
    public void sayHello(){
        System.out.println("Student says hello");
    }
    
}

// class CommandLineRunner {
//     public void run(String... args) throws Exception {
//       System.out.println("this method is called after spring container is initialized");
//     }
// }