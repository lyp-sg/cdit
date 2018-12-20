package com.yongpeng.dev.cdit.Configuration;

import com.yongpeng.dev.cdit.Service.UserServiceImpl;
import com.yongpeng.dev.cdit.Service.StubUserServiceImpl;
import com.yongpeng.dev.cdit.Service.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfiguration {

    @Bean
    @ConditionalOnProperty(name = "environment.name", havingValue = "local", matchIfMissing = true)
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    @ConditionalOnProperty(name = "environment.name", havingValue = "test")
    public UserService stubUserService() {
        return new StubUserServiceImpl();
    }
}
