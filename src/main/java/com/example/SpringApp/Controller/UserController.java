package com.example.SpringApp.Controller;

import com.example.SpringApp.Model.User;
import com.example.SpringApp.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name="Controlador Usuarios",description = "Servicio de gestion de usuarios Fullstack I")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @Operation(summary = "Obtener Usuarios",description = "Obtiene la lista de usuarios existentes en el sistema")
    @ApiResponse(responseCode="200",description = "Consulta Exitosa")
    public String getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id) {
        return userService.getuser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public String putUserById(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}
