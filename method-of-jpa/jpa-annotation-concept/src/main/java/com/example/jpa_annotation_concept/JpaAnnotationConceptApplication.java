package com.example.jpa_annotation_concept;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor 
public class JpaAnnotationConceptApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAnnotationConceptApplication.class, args);
	}

	private  final EmployeeRepository repository ;

	@Bean 
	public CommandLineRunner commandLineRunner(){
		return  args ->{
			// Employee employee=new Employee(niull,"ram",368.00)//it mot write explictly beccoz of builkder anotation
			Employee employee = Employee.builder()
									.name("Ranjit nayak")
									.description("ranjit is a loyal employee")
									.salary(BigDecimal.valueOf(10000.00))
									.status(EmployeStatus.ACTIVE)
									.build();

		Employee emp =repository.save(employee);//for save the above databese
		Employee savedEmployee = repository
							.findById(emp.getId()).orElseThrow();

		savedEmployee.setName("Ankit kumar");
		savedEmployee.setDescription("Anlkit is a good guy ");


		repository.save(savedEmployee);

		
		};
	}

}
