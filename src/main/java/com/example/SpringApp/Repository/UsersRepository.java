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
        users.add(new User("User1","Password1","Correo@Test.com"));
        users.add(new User("User2","Password2","CorreoTest.com"));
        users.add(new User("User3","Password3","CorreoTest.com"));
    }

    //CRUD

    public String addUser(String username, String password, String email) {
        User user = new User(username, password, email);
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
