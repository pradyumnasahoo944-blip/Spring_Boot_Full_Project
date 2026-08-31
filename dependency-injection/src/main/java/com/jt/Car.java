package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
//    private  Enginee enginee = new Enginee();

   //DI(dependancy injection )
   //di is mechanism in which spriong container atumaticallty inject the bean inside a class refrence variable 
   // in simole word spring container automatically assing the addd of the bean inside anothwwr calsss ref variabke 
   //1st way ===fieldd based injection-NR
//     @Autowired//to performe DI
//    private Enginee enginee ;
   //2 nd === Setter method based injecytion -R
    // private Enginee enginee ;
    // @Autowired
    // public void setEngine(Enginee enginee){
    //     System.out.println("parameter engine is "+enginee);
    //     System.out.println("varibale  engine is "+this.enginee);

    //     this.enginee =enginee;

    // }



   //3 == Constructer based injection -HR
    private Enginee enginee;
    @Autowired
    public Car(@Qualifier("petro")Enginee enginee){//if thjere is multiplre primery is presernt the i write the confirm interfaces reference or value 
        this.enginee =enginee;
        System.out.println("parameterezide constructer");
    }
    // public Car(){
    //     System.out.println("non pssrarmeterized const");
    // }
    public void startCar(){
        // Enginee enginee = new Enginee();
        enginee.startEnginee();
        System.out.println("car is started ");
    }
    public void stopCar(){
        // Enginee enginee = new Enginee();
        enginee.stopEnginee();
        System.out.println("car is stop ");
    }


}
