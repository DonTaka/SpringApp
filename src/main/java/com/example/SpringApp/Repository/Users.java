package com.example.SpringApp.Repository;

import java.util.List;
import java.util.ArrayList;

import com.example.SpringApp.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public class Users {
    //Clase Arreglo de Usuarios
    //ArrayList
    private List<User> users = new ArrayList<User>();

    public Users() {

    }

    //CRUD

    public void addUser(User user) {
        users.add(user);
        System.out.println("Agregado con exito");
    }

    public String getUser(String userName) {

        for (User temp : users) {
            if (temp.getUsername().equalsIgnoreCase(userName)) {
                return temp.toString();
            }
        }
        return "No existe el usuario con ese nombre";
    }

    public void removeUser(String userName) {
        for (User temp : users) {
            if (temp.getUsername().equalsIgnoreCase(userName)) {
                users.remove(temp);
                System.out.println("Eliminado con exito");
                break;
            }
        }
        System.out.println("No existe el usuario con ese nombre");
    }

    public void updateUser(User user) {
        int index = 0;
        for (User temp : users) {
            if (temp.getUsername().equalsIgnoreCase(user.getUsername())) {
                index = users.indexOf(temp);
                break;
            }
        }
        if (index != -1) {
            users.set(index, user);
            System.out.println("Actualizado con exito");
        } else {
            System.out.println("No existe el usuario con ese nombre");
        }
    }


}
