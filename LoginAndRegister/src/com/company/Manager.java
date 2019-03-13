package com.company;

public class Manager {

    Login loginPage;
    Register registerPage;
    Baza database = null;

    Manager(Baza baza){
        this.database = baza;
    }

    public void openLogin(){
        loginPage = new Login(this);
    }

    public void openRegister(){
        registerPage = new Register(this);
    }

    public void index(User user){
        // Vodi unutar aplikacije
        System.out.println("Logiran user: " + user.getEmail());

    }

    public Baza getDatabase(){
        return this.database;
    }


}
