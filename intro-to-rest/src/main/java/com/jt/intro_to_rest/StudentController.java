package com.jt.intro_to_rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

// @Controller
//  @ResponseBody
 @RestController//both Controller,ResponseBody   merge to create  @RestController
public class StudentController {

    private ObjectMapper mapper;

    public StudentController(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    // @ResponseBody
    public Student getStudent() {

        Student student = new Student(
                101,
                "Ankit",
                new String[]{"java", "python"}
        );

        return student;
    }

    @RequestMapping("/student1")
    // @ResponseBody
    public String convertJavaObjToJson() throws JacksonException {

        Student student = new Student(
                101,
                "Ankit",
                new String[]{"java", "python"}
        );

        String json = mapper.writeValueAsString(student);//it mean java to json

        System.out.println("json value is " + json);

        return json;
    }

    @RequestMapping("/student2")
    // @ResponseBody
    public Student convertJsonToJavaObj() throws JacksonException {

        String json = """
                {
                    "id": 102,
                    "name": "Aniket",
                    "courses": ["c", "c++"]
                }
                """;

        Student student = mapper.readValue(json, Student.class);//json to java 

        System.out.println("Student = " + student);

        return student;
    }

    @RequestMapping("/fruits")
    // @ResponseBody//it mean our file instead of requiring html file it search an json file 
    public List<String> getStrings (){
        return List.of("Apple ","Mango","Grapes ");

    }
}