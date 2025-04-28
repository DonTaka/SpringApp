package com.example.SpringApp.Controller;

import com.example.SpringApp.Model.User;
import com.example.SpringApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String getUser(){
        return userService.getUsers();
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user, @RequestParam String password){
        return userService.addUser(user.getUsername(),user.getPassword(),user.getEmail());
    }
}
