package com.example.SpringApp.Repository;

import java.util.List;
import java.util.ArrayList;

import com.example.SpringApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {


}
