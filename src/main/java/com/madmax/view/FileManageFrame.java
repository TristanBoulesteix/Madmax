package com.madmax.view;

import javax.swing.*;

public class FileManageFrame extends JFrame {

    private static FileManageFrame instance;

    public static FileManageFrame getInstance(){
        if(instance == null)
        {
            instance = new FileManageFrame();
        }


        return instance;
    }
}
