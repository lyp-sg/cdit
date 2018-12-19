package com.yongpeng.dev.cdit.DTO;

import java.util.List;

public class UsersDTO<T> implements ResultsDTO<T>{

  private final List<T> users;

  public UsersDTO(List<T> users){
    this.users = users;
  }

  public List<T> getResults(){
    return this.users;
  }

}
