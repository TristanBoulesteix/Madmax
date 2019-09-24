package com.madmax.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DecryptFrame extends JFrame implements KeyListener {
    private static DecryptFrame instance;

    private DecryptPanel panel;
    private JTextField message;
    private JButton decrypt;

    private DecryptFrame() {

        this.setSize(500,375);
        this.setUndecorated(false);
        this.setTitle("DECRYPTION");
        this.setResizable(false);
        addKeyListener(this);
        this.panel = new DecryptPanel();
        this.panel.setLayout(new FlowLayout());
        this.decrypt = new JButton("Decrypt");
        this.message = new JTextField();

        panel.add(message);
        panel.add(decrypt);
        this.add(panel);
        this.setVisible(true);
    }

    public static DecryptFrame getInstance(){

        if(instance == null)

        {

            instance = new DecryptFrame();

        }


        return instance;
    }

}