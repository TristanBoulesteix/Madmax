package com.madmax;
import com.madmax.view.auth.AuthFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        AuthFrame.getInstance().setVisible(true);
    }
}
