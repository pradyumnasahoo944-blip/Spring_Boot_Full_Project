package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

public class DisealEnginne implements Enginee {

    @Override
    public void startEnginee() {
      
        System.out.println("Diseal engine  engenee starting");
    }

    @Override
    public void stopEnginee() {
       
    System.out.println("Diseal engine  engenee stoping");
    }

    
}
    
