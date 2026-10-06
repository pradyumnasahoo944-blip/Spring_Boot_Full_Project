package com.exampe.one_to_one;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToOneApplication {

	private final StudentRepository studentRepository;
	private final AdressRepository adressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return  args->{

			InverseSide();

			//this is owning side
//			Adress adress =Adress.builder()
//					.city("BBSR")
//					.country("india")
//					.state("odisha")
//					.build();
//
//			Student student =Student.builder()
//					.studentName("aravind")
//					.studentEmail("a@gmail.com")
//					.adress(adress)
//					.build();
	//becoz when we try to save owning side ,inverse side must be prersent in databse so i commented it
			//studentRepository.save(student);
			//it is mannualy concept to save
//			adressRepository.save(adress);
//			studentRepository.save(student);


			//by using cascading 1st  go to clo0ning side then save it
//			studentRepository.save(student);


			//update
//				Student existingStudent=studentRepository.findById(1).orElseThrow();
//				existingStudent.setStudentName("Pradyumna");
//				existingStudent.setStudentEmail("p@gmail.com");
//				Adress existingAdress=existingStudent.getAdress();
//				existingAdress.setCity("Cuttack");
//				studentRepository.save(existingStudent);
			//REMOVE
//		studentRepository.deleteById(6);
//		   Student Withroll5 =studentRepository.findById(5).orElseThrow();
//			System.out.println("Student name :-"+Withroll5.getStudentName());
//			System.out.println("Student email :-"+Withroll5.getStudentEmail());
//
//
//			Adress Withroll5Adress =Withroll5.getAdress();
//			System.out.println("Adress city "+Withroll5Adress.getCity());
//			System.out.println("Adresss country "+Withroll5Adress.getCountry());
//			System.out.println("Adress State is "+Withroll5Adress.getState());
		};

	}

	private void InverseSide(){
		Student student = Student.builder()
				.studentName("pradyumna ")
				.studentEmail("p@gmail.com")

				.build();

		Adress adress=Adress.builder()
				.state("up")
				.country("India")
				.city("bbsr")
				.student(student)
				.build();
		student.setAdress(adress);
//		adressRepository.save(adress);
		//UPDATE
	Adress existingStudent =  adressRepository.findById(1).orElseThrow();
	//for updating address data
		existingStudent.setState("odisha");
		existingStudent.setCity("rourkela");
	//for updating student data
	Student student1 =existingStudent.getStudent();
//		System.out.println(student1);
		student1.setStudentName("Manoj");
		student1.setStudentEmail("@manoj");
		adressRepository.save(existingStudent);


		Adress withroll = adressRepository.findById(1).orElseThrow();
		System.out.println(withroll.getCity());
		Student withst=withroll.getStudent();
		System.out.println(withst.getStudentName());





	}
}
