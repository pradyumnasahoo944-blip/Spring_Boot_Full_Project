package com.example.many_to_many;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class ManyToManyApplication {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
//			oneWayBinding();

            //		inverse side
            subjectRepository.findAll().forEach(subject -> {
                subject.getStudents().forEach(student -> {
                    System.out.println(subject.getSubjectName()+ " => "+ student.getStudentName());
                });
            });

        };
    }

    private void oneWayBinding() {
//==============SAVE==============
        Subject subject1 = Subject.builder().subjectName("C").build();
        Subject subject2 = Subject.builder().subjectName("Java").build();
        Subject subject3 = Subject.builder().subjectName("C++").build();


        Student student1 = Student.builder()
                .studentName("Amit")
                .studentEmail("amit@gmail.com")
                .subjects(List.of(subject1, subject2, subject3))
                .build();
        Student student2 = Student.builder()
                .studentName("Satya")
                .studentEmail("satya@gmail.com")
                .build();
        Student student3 = Student.builder()
                .studentName("Rahul")
                .studentEmail("rahul@gmail.com")
                .build();


        studentRepository.saveAll(List.of(student1, student2, student3));

        //update

        //delete
        //extract

        studentRepository.findAll().forEach(student -> {
            student.getSubjects().forEach(subject -> {
                System.out.println(student.getStudentName() + "\t=>\t" + subject.getSubjectName());
            });
        });
    }
}