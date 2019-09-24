package com.madmax;

import javax.swing.*;

public class Main {
    public static void main (String[] args){
        System.out.println("Hello world !");
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
