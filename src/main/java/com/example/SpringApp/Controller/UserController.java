package com.example.SpringApp.Controller;

import com.example.SpringApp.Model.User;
import com.example.SpringApp.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name="Controlador Usuarios",description = "Servicio de gestion de usuarios Fullstack I")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @Operation(summary = "Obtener Usuarios",description = "Obtiene la lista de usuarios existentes en el sistema")
    @ApiResponse(responseCode="200",description = "Consulta Exitosa")
    public ResponseEntity<List<User>> getUsers() {
        List<User> lista = userService.getUsers();
        if (!lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        if (userService.getuser(user.getId()).isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        if (userService.getuser(id).isPresent()) {
            User us = userService.getuser(id).get();
            return new ResponseEntity<>(us, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteUserById(@PathVariable int id) {
        if (userService.getuser(id).isPresent()) {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> putUserById(@PathVariable int id, @RequestBody User user) {
        if (userService.getuser(id).isPresent()) {
            userService.updateUser(id, user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
