package com.example.SpringApp.Service;

import com.example.SpringApp.Repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    Users users = new Users();

    public String getUser(String username){
        return users.getUser(username);
    }
}
