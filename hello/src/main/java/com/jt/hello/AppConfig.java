package com.jt.hello;

import java.lang.foreign.MemorySegment.Scope;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
   
    public Student student(){
        //Student ss = new Student();
        //return ss
        return new Student();
    }

    // @Bean
    // public CommandLineRunner commandLineRunner(){
    //     return args -> {
    //         System.out.println("this method is called after spring container is initialized");
    //     };
    // }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("padia");
        };
    }
}
