package com.company;

public class Main {


    public static void main(String[] args) {
	// write your code here
        Baza baza = Baza.getInstance();
        Manager manager = new Manager(baza);

        manager.openRegister();

        // new SeminarJava("Ovo je primjer za Javu");

    }
}
