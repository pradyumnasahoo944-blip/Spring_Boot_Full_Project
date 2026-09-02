package com.jt.expense_tracker;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Expense {
    private int id ;
    private String  title ;
    private String  catagory ;
    private double  price ;
    private LocalDate date ;



    //  public Expense() {
    // }

    //   public Expense(int id, String title, String catagory, double price, LocalDate date) {
    //     this.id = id;
    //     this.title = title;
    //     this.catagory = catagory;
    //     this.price = price;
    //     this.date = date;
    // }


    // public int getId() {
    //     return id;
    // }
    // public void setId(int id) {
    //     this.id = id;
    // }
    // public String getTitle() {
    //     return title;
    // }
    // public void setTitle(String title) {
    //     this.title = title;
    // }
    // public String getCatagory() {
    //     return catagory;
    // }
    // public void setCatagory(String catagory) {
    //     this.catagory = catagory;
    // }
    // public double getPrice() {
    //     return price;
    // }
    // public void setPrice(double price) {
    //     this.price = price;
    // }
    // public LocalDate getDate() {
    //     return date;
    // }
    // public void setDate(LocalDate date) {
    //     this.date = date;
    // }
    
    
}
