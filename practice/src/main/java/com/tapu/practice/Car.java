package com.tapu.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Autowired    

    
    private Engine engine ;
    public void startCar(){
        // Engine engine = new Engine();
        engine.startEngine();
        System.out.println("car is startde ");
    }
    public void stopCar(){
        // Engine engine = new Engine();
        engine.stopEngine();
        System.out.println("car is stoped");
    }


    
}
