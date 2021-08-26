package com.fagoner.userservice;

import com.fagoner.userservice.domain.Role;
import com.fagoner.userservice.domain.User;
import com.fagoner.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {

//            Role roleAdmin = new Role(0, "ROLE_ADMIN");
//            Role roleLector = new Role(0, "ROLE_LECTOR");
//
//            userService.saveRole(roleAdmin);
//            userService.saveRole(roleLector);
//
//            User adminUser = new User(0, "admin user1", "adminUser", "1234");
//            User lectorUser = new User(0, "lector user2", "lectorUser", "1234");
//
//            userService.saveUser(adminUser);
//            userService.saveUser(lectorUser);
//
//            userService.addRoleToUser(adminUser.getId(), roleAdmin.getId());
//            userService.addRoleToUser(lectorUser.getId(), roleLector.getId());

        };
    }

}
