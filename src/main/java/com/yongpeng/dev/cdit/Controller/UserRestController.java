package com.yongpeng.dev.cdit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.yongpeng.dev.cdit.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yongpeng.dev.cdit.DTO.UserDTO;
import com.yongpeng.dev.cdit.DTO.ResultsDTO;
import com.yongpeng.dev.cdit.DTO.ListResultsDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

  @Autowired
  private UserService userService;

  @RequestMapping("/users")
  public ResultsDTO<UserDTO> users() {
    ResultsDTO<UserDTO> results = new ListResultsDTO<UserDTO>(userService.findByRequiredRange());
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

  @RequestMapping(method = RequestMethod.POST, value="/create/users")
  public ResponseEntity<String> CreateUser(@RequestBody List<UserDTO> users ){
    for(UserDTO user: users){
      if(!userService.IsValid(user))
      {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
      }
    }

    for(UserDTO user: users) {
      userService.createUser(user);
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
  @RequestMapping("/test")
  public void test(){
    String uri = "http://localhost:8080/create/users";
    List<UserDTO> list = new ArrayList<UserDTO>();
    UserDTO user = new UserDTO("Alan",1000.0);
    list.add(user);
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForObject(uri,list, ResponseEntity.class);
  }
}
