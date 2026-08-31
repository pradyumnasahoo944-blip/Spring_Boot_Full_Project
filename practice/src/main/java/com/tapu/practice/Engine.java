package com.tapu.practice;

import org.springframework.stereotype.Component;

@Component

public class Engine {

    public void startEngine(){
        System.out.println("Engine is startted");
    }

    public void stopEngine(){
        System.out.println("Engine is stoped ");
    }
    
}
