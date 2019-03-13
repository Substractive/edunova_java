package com.company;

import java.util.ArrayList;

public class Baza {

    private ArrayList<User> users;
    private static Baza instance = null;
    private Baza(){
        users = new ArrayList<User>();
    }

    public static Baza getInstance(){
        if (instance == null)
            instance = new Baza();

        return instance;
    }


    public boolean saveUser(User user){
        try{
            this.users.add(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public User getUser(int ID){
        for (User user : this.users) {
            if (user.getID() == ID) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String email, String password){
        for (User user : this.users) {
            if (user.getEmail().equals(email) && BCrypt.checkpw(password,user.getPassword())) {
                return user;
            }
        }
        return null;
    }

}
