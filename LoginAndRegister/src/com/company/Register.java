package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {

    JLabel pageTitle, emailLabel, passwordLabel, passwordRepeatLabel;
    JTextField emailInput;
    JButton btn1;
    JPasswordField passwordInput,passwordRepeatInput;
    Manager reference;

    // konstruktor koji kreira login view
    Register(Manager reference)
    {
        this.reference = reference;
        setTitle("Register");
        setVisible(true);
        setSize(800, 800);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pageTitle = new JLabel("Register");
        pageTitle.setForeground(Color.blue);
        pageTitle.setFont(new Font("Serif", Font.BOLD, 20));

        emailLabel = new JLabel("Enter Email:");
        passwordLabel = new JLabel("Enter Password:");
        passwordRepeatLabel = new JLabel("Repeat Password:");
        emailInput = new JTextField();
        passwordInput = new JPasswordField();
        passwordRepeatInput = new JPasswordField();
        btn1 = new JButton("Submit");

        pageTitle.setBounds(100, 30, 400, 30);
        emailLabel.setBounds(80, 70, 200, 30);
        passwordLabel.setBounds(80, 110, 200, 30);
        passwordRepeatLabel.setBounds(80, 150, 200, 30);
        emailInput.setBounds(300, 70, 200, 30);
        passwordInput.setBounds(300, 110, 200, 30);
        passwordRepeatInput.setBounds(300, 150, 200, 30);
        btn1.setBounds(350, 190, 100, 30);

        add(pageTitle);
        add(emailLabel);
        add(emailInput);
        add(passwordLabel);
        add(passwordRepeatLabel);
        add(passwordInput);
        add(passwordRepeatInput);
        add(btn1);
        // btn1.addActionListener(this);
        // submit btn klik event
        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                doRegister();
            }
        });
    }

    // metoda koja se poziva na submit btn
    public void doRegister(){
        System.out.println("Register");
        String str1 = emailInput.getText();

        String password = new String(this.passwordInput.getPassword());
        String repeatPassword = new String(this.passwordRepeatInput.getPassword());

        if(password.equals(repeatPassword)){ // Passwordi su jednaki

            password = BCrypt.hashpw(password,BCrypt.gensalt(10));
            //System.out.println("Hashed password:" + password);

            if(this.saveUser(str1,password)){
                int buttonClicked = JOptionPane.showConfirmDialog(
                        this,
                        "Uspješna registracija. Ok -> nastavak na prijavu, Cancel -> Ostani na registraciji","Registracija",
                        JOptionPane.OK_CANCEL_OPTION);

                switch (buttonClicked){
                    case 0: // OK
                        this.dispose();
                        this.reference.openLogin();
                        break;
                    case 2: // Cancel
                        this.emailInput.setText("");
                        this.passwordInput.setText("");
                        this.passwordRepeatInput.setText("");
                        break;
                }
            }
        }
    }

    private boolean saveUser(String email, String password){

        // spremanje u bazu ili server...

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);

        Baza database = reference.getDatabase();
        if(database.saveUser(newUser)){
            return true;
        }

        return false;
    }



}
