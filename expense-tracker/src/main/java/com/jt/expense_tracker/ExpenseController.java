package com.jt.expense_tracker;

import java.beans.BeanProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

@RestController
@RequiredArgsConstructor

public class ExpenseController {

    private final JdbcTemplate jdbcTemplate ;//here i use final because i want to use it in constructor and i want to make it immutable and it restrict auto initialization of jdbcTemplate and i want to initialize it in constructor only
//so i comment xonstructer  bellow
    // public ExpenseController(JdbcTemplate jdbcTemplate){
        
    //     this.jdbcTemplate =jdbcTemplate ;
    // }
    @RequestMapping(value ="/expenses",method =RequestMethod.GET)
    public List<Expense> getExpenses(){
        String sql ="SELECT * FROM expenses";
        // List<Expense> expense = new ArrayList<>();
        // jdbcTemplate.query(sql,(resulSet)->{
        //     System.out.println("id is "+resulSet.getInt("id"));
        //     System.out.println("title is "+resulSet.getString("title"));
        //     System.out.println("cvatergory is "+resulSet.getString("catagory"));

        //     var id = resulSet.getInt("id");
        //     var title = resulSet.getString("title") ;
        //     var catagory = resulSet.getString("catagory") ;
        //     var price = resulSet.getDouble("price") ;
        //     LocalDate date = resulSet.getDate("date").toLocalDate();//date have a object whoich convert date into local date

        //     var expenses = new Expense(id ,title,catagory,price,date);

        //     expenses.add(expense);
        // });

    // List<Expense> expenses = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Expense>(Expense.class));
    //     return expenses ;
    return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Expense>(Expense.class));

    }
}
///if i get  multiple vakye thebn i use query 
/// //for sinfle val;yue query forobject
/// //update dml ,ddl
/// ROWmapper is interface which is  given by sb (wrapper around resulset)
/// JdbcTemplate is provided by Spring JDBC and makes JDBC code much easier.
/// query()	Get multiple rows
//queryForObject()	Get one result/object
//update()	INSERT, UPDATE, DELETE
//execute()	Execute general SQL
//to show above code cereate an object amd class


//lombok use to get maximum code reduction and less boilerplate code
//@noArgconstructer creaate a nonn parameterzide coinstructor  examople 
//@RequiredArgsConstructor create a parameterized constructor but only with final instance variable 
//@AllArgsConstructor create a parameterized constructor with all instance variable