package com.jt.hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.Teacher;

@ImportResource("beans.xml")
@SpringBootApplication
@ComponentScan(basePackages = {"com"} )
public class HelloApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloApplication.class, args);
		//1st way using xml file
		Greet greet = context.getBean(Greet.class);
		greet.sayHello();
		//usinng stereotype annotation
		Person person = context.getBean(Person.class);
		person.sayHello();
		//3rd way using configuration file 
		Student student = context.getBean(Student.class);
		student.sayHello();


		Teacher teacher = context.getBean(Teacher.class);
		teacher.sayHello();

		System.out.println(teacher.hashCode());
		Teacher teacher1 = context.getBean(Teacher.class);
		System.out.println(teacher1.hashCode());


		System.out.println("Student"+student.hashCode());
		Student student2 = context.getBean(Student.class);	
		System.out.println("Student1"+student2.hashCode());	

			try{
				CommandLineRunner cmd = context.getBean(CommandLineRunner.class);
				cmd.run("a");
			}catch(Exception ee){
				ee.printStackTrace();
			}
		
	}
	 


}



