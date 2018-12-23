package com.yongpeng.dev.cdit;

import org.junit.Test;
import com.yongpeng.dev.cdit.DTO.UserDTO;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import com.yongpeng.dev.cdit.Repository.UserRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.yongpeng.dev.cdit.Service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.test.context.TestConfiguration;
import com.yongpeng.dev.cdit.Service.UserService;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserServiceImplIntegrationTest{

  @TestConfiguration
  static class UserServiceImplTestContextConfiguration {
    @Bean
    public UserService userService() {
      return new UserServiceImpl();
    }
  }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setup(){
      List<UserDTO> userList = new ArrayList<UserDTO>();
      userList.add(new UserDTO("Alan",1000.0));
      userList.add(new UserDTO("Ben",4000.0));
      Mockito.when(userRepository.findByMinMaxAmountRange(1000,4000)).thenReturn(userList);
    }

    @Test
    public void findUserByRequiredRange(){

      List<UserDTO> userList =userService.findByRequiredRange();
      List<UserDTO> expectedList = new ArrayList<UserDTO>();
      expectedList.add(new UserDTO("Alan",1000.0));
      expectedList.add(new UserDTO("Ben",4000.0));

      assertThat(userList.get(0).getName(), is(expectedList.get(0).getName()));
      assertThat(userList.get(0).getSalary(), is(expectedList.get(0).getSalary()));
      assertThat(userList.get(1).getName(), is(expectedList.get(1).getName()));
      assertThat(userList.get(1).getSalary(), is(expectedList.get(1).getSalary()));
    }
}
