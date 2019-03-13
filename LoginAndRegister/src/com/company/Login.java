/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author Dino
 */

public class Login extends JFrame
{
    JLabel pageTitle, emailLabel, passwordLabel;
    JTextField emailInput;
    JButton btn1;
    JPasswordField passwordInput;
    Manager reference;

    // konstruktor koji kreira login view
    Login(Manager reference)
    {
        this.reference = reference;
        setTitle("Login");
        setVisible(true);
        setSize(800, 800);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pageTitle = new JLabel("Login");
        pageTitle.setForeground(Color.blue);
        pageTitle.setFont(new Font("Serif", Font.BOLD, 20));

        emailLabel = new JLabel("Enter Email:");
        passwordLabel = new JLabel("Enter Password:");
        emailInput = new JTextField();
        passwordInput = new JPasswordField();
        btn1 = new JButton("Submit");

        pageTitle.setBounds(100, 30, 400, 30);
        emailLabel.setBounds(80, 70, 200, 30);
        passwordLabel.setBounds(80, 110, 200, 30);
        emailInput.setBounds(300, 70, 200, 30);
        passwordInput.setBounds(300, 110, 200, 30);
        btn1.setBounds(150, 160, 100, 30);

        add(pageTitle);
        add(emailLabel);
        add(emailInput);
        add(passwordLabel);
        add(passwordInput);
        add(btn1);
       // btn1.addActionListener(this);
        // submit btn klik event
        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    doLogin();
            }
        });
    }

    // metoda koja se poziva na submit btn
    public void doLogin(){
        String str1 = emailInput.getText();
       
        String password = new String(this.passwordInput.getPassword());
        User logUser = provjeriPrijavu(str1,password);
        if( logUser != null){
            // user je provjeren i sve ok.
            // ugasi window i idi dalje u app
            this.dispose();
            this.reference.index(logUser);
        }
    }

    private User provjeriPrijavu(String email, String password){

        // neka vrsta provjere
        // na bazu da li postoji taj user i ako password odgovara
        // vrati true i idi dalje u app
        Baza database = reference.getDatabase();
        User loggedInUser = database.getUser(email,password);
        if(loggedInUser != null){
            return loggedInUser;
        }

        return null;

    }

}
