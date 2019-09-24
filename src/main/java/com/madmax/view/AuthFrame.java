package com.madmax.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AuthFrame extends JFrame implements KeyListener {
    private static AuthFrame instance;

    private AuthPanel panel;
    private JPasswordField pass;
    private JTextField id;
    private JButton login;


    private AuthFrame(){
        this.setSize(500,375);
        this.setUndecorated(false);
        this.setTitle("LOGIN");
        this.setResizable(false);
        addKeyListener(this);
        this.panel = new AuthPanel();
        this.setLayout();
        this.login = new JButton("Begin Hack");
        this.id = new JTextField();
        this.pass = new JPasswordField();

        panel.add(login);
        login.setLocation(50,50);

        panel.add(pass);
        pass.setSize(50,150);

        panel.add(id);
        id.setSize(50,150);

        this.add(panel);
        this.repaint();

        this.setVisible(true);
    }

    public static AuthFrame getInstance(){

        if(instance == null)

        {

            instance = new AuthFrame();

        }


        return instance;
    }



    public static void setInstance(AuthFrame instance) {
        AuthFrame.instance = instance;
    }

    public AuthPanel getPanel() {
        return panel;
    }

    public void setPanel(AuthPanel panel) {
        this.panel = panel;
    }

    public JPasswordField getPass() {
        return pass;
    }

    public void setPass(JPasswordField pass) {
        this.pass = pass;
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    public JButton getLogin() {
        return login;
    }

    public void setLogin(JButton login) {
        this.login = login;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if ( e.getKeyCode() == KeyEvent.VK_ESCAPE ) {
            this.dispose();
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paint(g);

    }
}
