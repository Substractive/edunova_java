package com.company;

public class Manager {

    Login loginPage;
    Register registerPage;

    public void openLogin(){
        loginPage = new Login(this);
    }

    public void openRegister(){
        registerPage = new Register(this);
    }

    public void index(){
        // Vodi unutar aplikacije
    }
}
