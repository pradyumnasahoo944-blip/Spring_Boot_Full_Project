package com.jt.expense_tracker;

import java.beans.BeanProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
   private static final String EXPENSES_TABLE = "expenses";
    // public ExpenseController(JdbcTemplate jdbcTemplate){
        
    //     this.jdbcTemplate =jdbcTemplate ;
    // }
    @RequestMapping(value ="/expenses",method =RequestMethod.GET)
    public List<Expense> getExpenses(){
        String sql ="SELECT * FROM %s".formatted(EXPENSES_TABLE);
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
    // @RequestMapping(value = "/expenses/{id}",method=RequestMethod.GET)//here id is path varibale it is called dynamic routiong
    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable int id){
        // System.out.println("Id is "+id);
        var sql = "SELECT * FROM %s WHERE id=?".formatted(EXPENSES_TABLE) ;
      Expense expense =  jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Expense.class),id);//if successful excute queryFOrObjexxt return full object otherwiode retuen null
        return expense;

    }
    // @RequestMapping(value = "/expenses",method =RequestMethod.POST )
    @PostMapping("/expenses")
    public Expense createExpense(@RequestBody Expense expense){//request body cis like model altribute
        var sql ="INSERT INTO %s(title ,category,price,date) VALUES(?,?,?,?)"
                                                    .formatted(EXPENSES_TABLE);
        jdbcTemplate.update(sql, expense.getTitle(), expense.getCategory(), expense.getPrice(), 
                                                                            expense.getDate());
        return expense ;
    }


    //delete
    // @RequestMapping(value = "/expenses/{id}",method =RequestMethod.DELETE )
    @DeleteMapping("/expenses/{id}")//i write this becoz i want only to delete so it is best
      public void deleteExpenses(@PathVariable int id ){
        String sql  = "DELETE FROM %s WHERE id =?".formatted(EXPENSES_TABLE);
        jdbcTemplate.update(sql, id);

      }



    //   @PatchMapping//to partiaal update
        @PutMapping("/expenses")//full update mean putmapping
        public Expense updateExpense(@RequestBody Expense expense ){
            var sql = "UPDATE %s SET title =? ,category =? ,price =?,date =? WHERE id =?".formatted(EXPENSES_TABLE);
            jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),expense.getPrice() ,expense.getDate(),expense.getId());
            return getExpenseById(expense.getId());//MEAN Expense update =  getExpenseById(expense.getId()//return update
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