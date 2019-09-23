package com.madmax.view;

import javax.swing.*;

public class FileManagePanel extends JPanel {

    private static FileManagePanel instance;

    public static  FileManagePanel getInstance() {
        if(instance == null)
        {
            instance = new FileManagePanel();
        }


        return instance;
    }

}
