package com.madmax.view;

import javax.swing.*;

public class AuthPanel extends JPanel {
    private static AuthPanel instance;

    public static AuthPanel getInstance(){
        if(instance == null)
        {
            instance = new AuthPanel();
        }


        return instance;

    }


}
