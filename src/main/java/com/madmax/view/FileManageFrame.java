package com.madmax.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FileManageFrame extends JFrame implements KeyListener {
    private static DecryptFrame instance;

    private FileManagePanel panel;
    private JTextField message;
    private JButton decrypt;

    private FileManageFrame() {

        this.setSize(500,375);
        this.setUndecorated(false);
        this.setTitle("DECRYPTION");
        this.setResizable(false);
        addKeyListener(this);
        this.panel = new FileManagePanel();
        this.panel.setLayout(new FlowLayout());
        this.decrypt = new JButton("Decrypt");
        this.message = new JTextField();

        panel.add(message);
        panel.add(decrypt);
        this.add(panel);
        this.setVisible(true);
    }

    public static FileManageFrame getInstance(){

        if(instance == null)

        {

            instance = new FileManageFrame();

        }


        return instance;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}