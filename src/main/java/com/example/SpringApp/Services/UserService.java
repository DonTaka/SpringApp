package com.example.SpringApp.Services;

import com.example.SpringApp.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public String getUsers(){
       return usersRepository.getUsers();
    }

    public String addUser(String username, String password, String email){
        return usersRepository.addUser(username, password, email);
    }
}
