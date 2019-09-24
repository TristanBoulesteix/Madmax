package com.madmax.view;

import javax.swing.*;
import java.awt.*;

public class AuthFrame extends JFrame {
    private static AuthFrame instance = new AuthFrame();

    public static AuthFrame getInstance(){
        return instance;
    }


    private AuthFrame(){
        this.setSize(500,375);
        this.setUndecorated(false);
        this.setTitle("LOGIN");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        this.initComponents();
    }

    private void initComponents() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints cLoginPanel = new GridBagConstraints();
        cLoginPanel.insets = new Insets(20, 20, 20, 20);
        this.add(loginPanel, cLoginPanel);

        JLabel label = new JLabel("Connexion");
        GridBagConstraints cLabel = new GridBagConstraints();
        cLabel.insets = new Insets(20, 50, 0, 50);
        cLabel.gridx = 0;
        cLabel.gridy = 0;
        loginPanel.add(label, cLabel);

        JTextField loginField = new JTextField();
        loginField.setPreferredSize(new Dimension(200, 25));
        GridBagConstraints cLoginFieldn = new GridBagConstraints();
        cLoginFieldn.gridx = 0;
        cLoginFieldn.gridy = 1;
        cLoginFieldn.insets = new Insets(10, 20, 20, 20);
        loginPanel.add(loginField, cLoginFieldn);
    }

    public void paintComponent(Graphics g) {
        super.paint(g);

    }
}
