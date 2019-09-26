package com.madmax;

import com.madmax.controller.Wkf_cpte;
import com.madmax.controller.Wkf_decrypt;
import com.madmax.model.Decrypt;
import com.madmax.model.Files;
import com.madmax.model.MapDic;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        Wkf_cpte.getInstance().showLoginFrame(false);

    }
}
