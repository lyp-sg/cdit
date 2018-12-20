package com.yongpeng.dev.cdit.Service;

import java.util.List;
import com.yongpeng.dev.cdit.Entity.User;
import com.yongpeng.dev.cdit.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.yongpeng.dev.cdit.Repository.UserRepository;

public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  public boolean IsValid(UserDTO user){
    return !user.getName().isEmpty() && user.getSalary()!=0;
  }

  public User createUser(UserDTO user){
    return userRepository.save(new User(user.getName(),user.getSalary()));
  }

  public User updateUser(UserDTO user){
    return userRepository.save(new User(user.getName(),user.getSalary()));
  }

  public List<UserDTO> findByRequiredRange()
  {
    List<UserDTO> userlist = userRepository.findByMinMaxAmountRange(1000, 4000);
    return userlist;
  }

}
