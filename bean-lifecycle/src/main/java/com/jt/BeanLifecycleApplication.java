package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanLifecycleApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(BeanLifecycleApplication.class, args);
		var greet=context.getBean(Greet.class);
		greet.greet();
	}
	/*
	Bean life cycle havre 5  phase which is mannged by spring container
	1.Bean instantiated====object is created -constructor- constructor
	2.DI(if available )                                  - by using aany way of DI
	3.Bean initialize-									 -@post constructor
	4.Bean used
	5.Bean destroy										 -@predestroyer
	*/



}
