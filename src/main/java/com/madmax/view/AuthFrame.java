package com.madmax.view;

import javax.swing.*;

public class AuthFrame extends JFrame {
    private static AuthFrame instance;

    public static AuthFrame getInstance(){
        if(instance == null)
        {
            instance = new AuthFrame();
        }


        return instance;
    }
}
