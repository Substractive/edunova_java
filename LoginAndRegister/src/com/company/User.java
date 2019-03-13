package com.company;

public class User {

    private int ID;
    private String name;
    private String email;
    private String password;

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
}
