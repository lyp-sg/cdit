package com.yongpeng.dev.cdit.Service;

import java.util.List;
import com.yongpeng.dev.cdit.Entity.User;
import com.yongpeng.dev.cdit.DTO.UserDTO;

public interface UserService{

  public boolean IsValid(UserDTO user);

  public User createUser(UserDTO user);

  public User updateUser(UserDTO user);

  public List<UserDTO> findByRequiredRange();

}
