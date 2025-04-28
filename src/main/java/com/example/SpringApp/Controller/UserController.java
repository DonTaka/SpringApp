package com.example.SpringApp.Controller;

import com.example.SpringApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{name}")
    public String getUser(@RequestParam String name) {
        return userService.getUser(name);
    }
}
