package com.example.huashangdian.views;

import java.util.ArrayList;

public class Users {

    String email;
    String password;
    static ArrayList<Users> users;

    public Users(String email, String password,ArrayList<Users> users ) {
        this.email=email ;
        this.password = password;
        this.users= users;
    }

    public Users(String email, String password) {
        this.email=email ;
        this.password = password;
    }
    
    public void setEmail(String userName) {
        email = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Users> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<Users> users) {
        Users.users = users;
    }
    
    public static Users loopArray(ArrayList<Users> users){
        Users u = null;
        for (Users user: users)
            u = user;
        return u;
    }

    @Override
    public String toString() {
        return "Users{" +
                "UserName='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
