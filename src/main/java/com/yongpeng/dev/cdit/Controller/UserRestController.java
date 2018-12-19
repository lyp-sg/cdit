package com.yongpeng.dev.cdit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.yongpeng.dev.cdit.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yongpeng.dev.cdit.DTO.UserDTO;
import com.yongpeng.dev.cdit.DTO.ResultsDTO;
import com.yongpeng.dev.cdit.DTO.ListDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

  @Autowired
  private UserService userService;

    @RequestMapping("/users")
    public ResultsDTO<UserDTO> users() {
      ResultsDTO<UserDTO> results = new ListDTO<UserDTO>(userService.findByRequiredRange());
      return results;
    }

    @RequestMapping(method = RequestMethod.POST, value="/create/user")
    public ResponseEntity<String> CreateUser(@RequestBody UserDTO user){
      if(userService.IsValid(user))
      {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
      }
      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }


}
