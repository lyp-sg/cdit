package com.yongpeng.dev.cdit.DTO;

import java.util.List;

public class ListDTO<T> implements ResultsDTO<T>{

  private final List<T> list;

  public ListDTO(List<T> list){
    this.list = list;
  }

  public List<T> getResults(){
    return this.list;
  }

}
