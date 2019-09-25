package com.madmax.view.auth;

import com.madmax.controller.utils.Observer;
import com.madmax.view.auth.components.JPasswordFieldWithPlaceHolder;
import com.madmax.view.auth.components.JTextFieldWithPlaceholder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class AuthFrame extends JFrame {
    private static final Dimension FIELD_DIMENSIONS = new Dimension(200, 25);
    private static final Dimension BUTTON_DIMENSIONS = new Dimension(100, 25);
    private static final Insets FIELD_INSETS = new Insets(10, 20, 20, 20);

    private List<Observer> observers = new ArrayList<>();
    private JTextFieldWithPlaceholder loginField;
    private JPasswordFieldWithPlaceHolder passField;

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public AuthFrame(boolean hasError) {
        this.setSize(500, 375);
        this.setUndecorated(false);
        this.setTitle("LOGIN");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        this.initComponents(hasError);

        this.setFocusable(true);
    }

    private void initComponents(boolean hasError) {
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
        loginField = new JTextFieldWithPlaceholder();
        loginField.addKeyListener(new ValidateForm("login"));
        loginField.setPreferredSize(FIELD_DIMENSIONS);
        loginField.setPlaceHolder("Login");
        GridBagConstraints cLoginFieldn = new GridBagConstraints();
        cLoginFieldn.gridx = 0;
        cLoginFieldn.gridy = 1;
        cLoginFieldn.insets = FIELD_INSETS;
        loginPanel.add(loginField, cLoginFieldn);

        // Password field
        passField = new JPasswordFieldWithPlaceHolder();
        passField.addKeyListener(new ValidateForm("pass"));
        passField.setPreferredSize(FIELD_DIMENSIONS);
        passField.setPlaceHolder("Password");
        GridBagConstraints cPassField = new GridBagConstraints();
        cPassField.gridx = 0;
        cPassField.gridy = 2;
        cPassField.insets = FIELD_INSETS;
        loginPanel.add(passField, cPassField);

        //Error field
        if (hasError) {
            JLabel errorField = new JLabel();
            errorField.setText("Nom d'utilisateur ou mot de passe invalide");
            errorField.setForeground(Color.RED);
            GridBagConstraints cErrorField = new GridBagConstraints();
            cErrorField.gridx = 0;
            cErrorField.gridy = 3;
            cErrorField.insets = FIELD_INSETS;
            loginPanel.add(errorField, cErrorField);
        }

        // Validation button
        JButton logInButton = new JButton("Connexion");
        logInButton.setPreferredSize(new Dimension(BUTTON_DIMENSIONS));
        logInButton.addActionListener(e -> {
            updateAllObservers();
        });
        GridBagConstraints cLogInButton = new GridBagConstraints();
        cLogInButton.gridx = 0;
        cLogInButton.gridy = hasError ? 4 : 3;
        cLogInButton.insets = FIELD_INSETS;
        loginPanel.add(logInButton, cLogInButton);
    }

    private void updateAllObservers() {
        for (Observer observer : observers) {
            observer.update(new String[]{loginField.getText(), new String(passField.getPassword())});
        }

        this.dispose();
    }

    private class ValidateForm implements KeyListener {
        private String component;

        ValidateForm(String component) {
            this.component = component;
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (component.equals("login")) {
                    passField.requestFocus();
                } else if (component.equals("pass")) {
                    updateAllObservers();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
