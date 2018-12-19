package com.yongpeng.dev.cdit.Entity;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class User{

  // @GeneratedValue
  // private Long id;
  @Id
  private String name;
  private double salary;

  public User(){
    
  }

  public User(String name, double salary){
    this.name = name;
    this.salary = salary;
  }

  // public User(Long id, String name, double salary){
  //   this.id = id;
  //   this.name = name;
  //   this.salary = salary;
  // }

  // public Long getId(){
  //   return id;
  // }
  //
  // public void setId(Long id){
  //   this.id = id;
  // }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public double getSalary(){
    return salary;
  }

  public void setSalary(double salary){
    this.salary = salary;
  }

}
