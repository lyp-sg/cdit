package com.yongpeng.dev.cdit.Controller;

import com.yongpeng.dev.cdit.DTO.UserDTO;
import com.yongpeng.dev.cdit.Repository.UserRepository;
import com.yongpeng.dev.cdit.Entity.User;
import com.yongpeng.dev.cdit.DTO.ResultsDTO;
import com.yongpeng.dev.cdit.DTO.UsersDTO;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

  private final UserRepository userRepository;

  public UserRestController(UserRepository userRepository) {
      this.userRepository = userRepository;
  }

    @RequestMapping("/users")
    public ResultsDTO<UserDTO> users() {
      userRepository.save(new User("Alan",900));
      userRepository.save(new User("Ben",1000));
      userRepository.save(new User("Clare",4000));
      userRepository.save(new User("Dan",4001));
      List<UserDTO> userlist = userRepository.findByMinMaxAmountRange(1000, 4000);
      ResultsDTO<UserDTO> results = new UsersDTO<UserDTO>(userlist);
      return results;
    }
}
