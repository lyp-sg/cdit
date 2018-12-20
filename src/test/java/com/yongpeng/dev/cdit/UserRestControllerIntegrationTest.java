package com.yongpeng.dev.cdit;

import org.springframework.http.MediaType;
import java.util.Arrays;
import com.yongpeng.dev.cdit.DTO.UserDTO;
import java.util.List;
import org.junit.Test;
import com.yongpeng.dev.cdit.Service.UserService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import com.yongpeng.dev.cdit.Controller.UserRestController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRestController.class)
public class UserRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    @Test
    public void whenGetUsers_thenReturnJsonArray()
      throws Exception {


        UserDTO alan = new UserDTO("Alan",1000.0);
        UserDTO ben = new UserDTO("Ben",4000.0);
        List<UserDTO> userList = Arrays.asList(alan,ben);
        given(service.findByRequiredRange()).willReturn(userList);

        mvc.perform(get("/users")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.results", hasSize(2)))
          .andExpect(jsonPath("$.results[0].name", is("Alan")))
          .andExpect(jsonPath("$.results[0].salary", is(1000.0)))
          .andExpect(jsonPath("$.results[1].name", is("Ben")))
          .andExpect(jsonPath("$.results[1].salary", is(4000.0)));
    }
}
