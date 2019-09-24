package com.madmax.view.auth;

import com.madmax.view.auth.components.JPasswordFieldWithPlaceHolder;
import com.madmax.view.auth.components.JTextFieldWithPlaceholder;

import javax.swing.*;
import java.awt.*;

public class AuthFrame extends JFrame {
    private static final Dimension FIELD_DIMENSIONS = new Dimension(200, 25);
    private static final Dimension BUTTON_DIMENSIONS = new Dimension(100, 25);

    private static AuthFrame INSTANCE = new AuthFrame();

    public static AuthFrame getInstance(){
        return INSTANCE;
    }

    private AuthFrame(){
        this.setSize(500,375);
        this.setUndecorated(false);
        this.setTitle("LOGIN");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        this.initComponents();

        this.setFocusable(true);
    }

    private void initComponents() {
        // Panel to show the login form
        JPanel loginPanel = new JPanel();
        loginPanel.setFocusable(true);
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints cLoginPanel = new GridBagConstraints();
        cLoginPanel.insets = new Insets(20, 20, 20, 20);
        this.add(loginPanel, cLoginPanel);

        // Connexion label
        JLabel label = new JLabel("Connexion");
        GridBagConstraints cLabel = new GridBagConstraints();
        cLabel.insets = new Insets(20, 50, 0, 50);
        cLabel.gridx = 0;
        cLabel.gridy = 0;
        loginPanel.add(label, cLabel);

        // Login field
        JTextFieldWithPlaceholder loginField = new JTextFieldWithPlaceholder();
        loginField.setPreferredSize(FIELD_DIMENSIONS);
        loginField.setPlaceHolder("Login");
        GridBagConstraints cLoginFieldn = new GridBagConstraints();
        cLoginFieldn.gridx = 0;
        cLoginFieldn.gridy = 1;
        cLoginFieldn.insets = new Insets(10, 20, 20, 20);
        loginPanel.add(loginField, cLoginFieldn);

        // Password field
        JPasswordFieldWithPlaceHolder passField = new JPasswordFieldWithPlaceHolder();
        passField.setPreferredSize(FIELD_DIMENSIONS);
        passField.setPlaceHolder("Password");
        GridBagConstraints cPassField = new GridBagConstraints();
        cPassField.gridx = 0;
        cPassField.gridy = 2;
        cPassField.insets = new Insets(10, 20, 20, 20);
        loginPanel.add(passField, cPassField);

        // Validation button
        JButton logInButton = new JButton("Connexion");
        logInButton.setPreferredSize(new Dimension(BUTTON_DIMENSIONS));
        GridBagConstraints cLogInButton = new GridBagConstraints();
        cLogInButton.gridx = 0;
        cLogInButton.gridy = 3;
        cLogInButton.insets = new Insets(10, 20, 20, 20);
        loginPanel.add(logInButton, cLogInButton);
    }
}
