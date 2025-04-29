package com.example.SpringApp.Controller;

import com.example.SpringApp.Model.User;
import com.example.SpringApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id){
        return userService.getuser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable int id){
        return userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public String putUserById(@PathVariable int id, @RequestBody User user){
        return userService.updateUser(id,user);
    }
}
