package com.yongpeng.dev.cdit.Service;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import com.yongpeng.dev.cdit.DTO.UserDTO;
import com.yongpeng.dev.cdit.Entity.User;

public class MockUserServiceImplement implements UserService{

  List<User> userList = new ArrayList<User>();

  public MockUserServiceImplement(){
      for(int i = 0; i < 5; i++){
        User user = new User("Test"+i,i*1000);
        userList.add(user);
      }
  }

  public boolean IsValid(UserDTO user){
    return true;
  }

  public User createUser(UserDTO user){
    User newUser = new User(user.getName(),user.getSalary());
    userList.add(newUser);
    return newUser;
  }

  public User updateUser(UserDTO user){
    User newUser = new User(user.getName(),user.getSalary());
    userList.add(newUser);
    return newUser;
  }

  public List<UserDTO> findByRequiredRange()
  {
    return userList.stream()
                    .filter(x-> x.getSalary() >= 1000 && x.getSalary()<=4000)
                    .map(x->new UserDTO(x.getName(),x.getSalary()))
                    .collect(Collectors.toList());
  }

}
