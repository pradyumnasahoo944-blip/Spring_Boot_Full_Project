package com.exampe.one_to_one;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToOneApplication {
    private  final SubjectRepository subjectRepository;
    private  final TeacherRepository teacherRepository;
    static void main(String[] args) {
        SpringApplication.run(ManyToOneApplication.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
//            oneWayBinding();
            Teacher newTeacher =Teacher.builder().teacherName("Ankit").build();
            Subject subject1=Subject.builder() .subjectName("   HTML") .teacher(newTeacher).build();
            Subject subject2=Subject.builder() .subjectName("CSS") .teacher(newTeacher).build();
            Subject subject3=Subject.builder() .subjectName("javaSCRIPT") .teacher(newTeacher).build();
            Subject subject4=Subject.builder() .subjectName("python") .teacher(newTeacher).build();

            newTeacher.setSubjects(List.of(subject1,subject2,subject3,subject4));
            teacherRepository.save(newTeacher);
            //EXTRACT
            teacherRepository.findById(1)
                    .orElseThrow()
                    .getSubjects()
                    .forEach(sub->{
                        System.out.println(sub.getTeacher()+"\t->\t"+sub.getSubjectName());
                    });

        };
    }

    private void oneWayBinding(){
        Teacher teacher =Teacher.builder()
                .teacherName("Amit")
                .build();
        Subject subject1=Subject.builder() .subjectName("C") .teacher(teacher).build();
        Subject subject2=Subject.builder() .subjectName("C++") .teacher(teacher).build();
        Subject subject3=Subject.builder() .subjectName("java") .teacher(teacher).build();
        Subject subject4=Subject.builder() .subjectName("python") .teacher(teacher).build();
//        subjectRepository.saveAll(List.of(subject1,subject2,subject3,subject4));
        //Update

        //delete

        //Extraction
        subjectRepository.findAll().forEach((Subject sub)->{
            System.out.println(sub.getSubjectName()+"\t->\t"+sub.getTeacher().getTeacherName());
        });



    }
}
