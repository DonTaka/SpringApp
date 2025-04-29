package com.example.SpringApp.Repository;

import java.util.List;
import java.util.ArrayList;

import com.example.SpringApp.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository {
    //Clase Arreglo de Usuarios
    //ArrayList
    private List<User> users = new ArrayList<User>();

    public UsersRepository() {

    }

    //CRUD

    public String addUser(User user) {
        users.add(user);
        return "Agregado con exito";
    }

    public String getUsers(){
        String output="";

        for(User u:users){
            output+= "Nombre Usuario: "+u.getUsername()+"\n";
            output+= "Contraseña: "+u.getPassword()+"\n";
            output+= "Correo Usuario: "+u.getEmail()+"\n";
        }

        if(output.length()>0){
            return output;
        }else{
            return "No se encuentran usuarios";
        }
    }

    public String getUser(int id) {

        for (User temp : users) {
            if (temp.getId() == id) {
                return temp.toString();
            }
        }
        return "No existe el usuario con ese nombre";
    }

    public String removeUser(int id) {
        for (User temp : users) {
            if (temp.getId() == id) {
                users.remove(temp);
                return"Eliminado con exito";
            }
        }
        return "No existe el usuario con ese nombre";
    }

    public String updateUser(int id ,User user) {
        int index = 0;
        for (User temp : users) {
            if (temp.getId() == id) {
                index = users.indexOf(temp);
                break;
            }
        }
        if (index != -1) {
            users.set(index, user);
            return "Actualizado con exito";
        } else {
           return "No existe el usuario con ese nombre";
        }
    }


}
