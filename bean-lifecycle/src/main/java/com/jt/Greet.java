package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Greet {
    private Greeting greeting ;

    public Greet (){
        System.out.println("Greet object is constructed");
    }
 @Autowired
    public void setGreeting(Greeting greeting){
        System.out.println("Grreting object is injected");
        this.greeting = greeting ;


    }

    @PostConstruct//it is used if we want to modify bean in bean at bean iinitialized time 
    public void init(){
        System.out.println("Bean is initialized");

    }

    @PreDestroy//if i want any modification at the time of bean destroy then i uses it 
    public void destroy(){
        System.out.println("Greet bean is destroyed");

    }
    public void greet(){
        System.out.println("Hello everyone ");
            // greeting.sayHii();

    }
    
}
