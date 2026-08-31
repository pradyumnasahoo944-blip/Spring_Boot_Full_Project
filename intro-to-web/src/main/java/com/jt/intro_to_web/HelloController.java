package com.jt.intro_to_web;

import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;

import jakarta.servlet.http.HttpServletRequest;

@Controller//it is used to make the class as controller class becoz to make this class as responsible as control the web

public class HelloController {

    @RequestMapping("/home")
    public void sayHello(PrintWriter writer){//Print Writer is used to  run the program in web 
        System.out.println("Hello Web");
        writer.println("<h1> Hello Spring Web </h1>  <p>Welcome</p>");

    }

    @RequestMapping("/")
    public void landingPage1(PrintWriter printWriter){
        System.out.println("landing page");
        printWriter.println("our first landing page1");
    }

    @RequestMapping("/contact")
    public String contact(){
      return "contact-page" ;

    }
    

    // @RequestMapping("/submit-details")
    // public String submitDetails(HttpServletRequest request ,Model model){
    //     System.out.println("submit deatils handled");
    //     String name = request.getParameter("name");
    //     String phone = request.getParameter("phone");


    //     // System.out.println("name  is "+ name );
    //     // System.out.println("phone is "+phone);



    //     model.addAttribute("name", name);
    //     model.addAttribute("phone", phone);

    //     return "details-page" ;


    //   @RequestMapping(value = "/submit-details",method =RequestMethod.POST)
    //   public String submitDetails(@RequestParam(value = "name1",required = false,defaultValue = "Springboot") String name1 ,@RequestParam String phone ,Model model){  
    // model.addAttribute("name1", name1);//whwn i send data java to html then i use model altribute//if i false the required then if i dont use name  in querystring then it dont show error
    // //if query param is preset=nt then use if not available then no problrmm
    // //required = false,defaultValue = "Springboot" is used in case of filtering thwe 
    // //tehre are differnt type of request is present 
    // // 1Get--to extract the resourse
    // // 2post---to create the resourse
    // // 3 put--to fully update a resourse
    // // 4patch----to partial update resourse
    // // 5Delete--to delete the resourse
    //   model.addAttribute("phone", phone);
    //   return "details-page" ;

    // }

      @RequestMapping(value = "/submit-details",method =RequestMethod.POST)
      public String submitDetails(@ModelAttribute Person person ,Model model){  
    model.addAttribute("name1", person.getName1
    ());//person is private so i use getName
    
      model.addAttribute("phone", person.getPhone());
      return "details-page" ;

    }
}
