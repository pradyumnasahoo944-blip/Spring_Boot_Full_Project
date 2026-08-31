package com.tapu.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		// SpringApplication.run(PracticeApplication.class, args);
		ApplicationContext context = SpringApplication.run(PracticeApplication.class,args);
		Car car = context.getBean(Car.class);
		car.startCar();
		car.stopCar();

	}

}
