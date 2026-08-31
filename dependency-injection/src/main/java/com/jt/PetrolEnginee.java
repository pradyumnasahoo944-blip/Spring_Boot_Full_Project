package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("petrol")//value 
public class PetrolEnginee implements Enginee {

    @Override
    @Primary//if there is two interfacee are present then primery is to bi write to gave attention to that interface

    public void startEnginee() {
      
        System.out.println("petrol engenee starting");
    }

    @Override
    public void stopEnginee() {
       
    System.out.println("petrol engenee stoping");
    }

    
}
