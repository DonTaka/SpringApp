package com.example.SpringApp.Services;

import com.example.SpringApp.Model.User;
import com.example.SpringApp.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public String getUsers() {
        return usersRepository.getUsers();
    }

    public String addUser(User user) {
        return usersRepository.addUser(user);
    }

    public String getuser(int id) {
        return usersRepository.getUser(id);
    }

    public String deleteUser(int id) {
        return usersRepository.removeUser(id);
    }

    public String updateUser(int id,User user) {
        return usersRepository.updateUser(id,user);
    }
}
