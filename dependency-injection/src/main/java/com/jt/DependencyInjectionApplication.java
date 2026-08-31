package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionApplication.class, args);

		ApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		// Enginee enginee =context.getBean(Enginee.class);
		// enginee.startEnginee();

		Car car = context.getBean(Car.class);
		car.startCar();
		car.stopCar();
	}

}
