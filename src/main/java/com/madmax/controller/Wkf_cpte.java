package com.madmax.controller;

import com.madmax.controller.utils.Observer;
import com.madmax.model.MapP;
import com.madmax.view.auth.AuthFrame;

public class Wkf_cpte implements Observer {
    private static final Wkf_cpte INSTANCE = new Wkf_cpte();

    public static Wkf_cpte getInstance() {
        return INSTANCE;
    }

    public void showLoginFrame() {
        AuthFrame frame = new AuthFrame();
        frame.addObserver(this);
        frame.setVisible(true);
    }

    private Wkf_cpte() {}

    private boolean pcs_authentifier(String login, String password) {
        String test = MapP.getInstance().selectIDbyLoginPassword(login, password);
        System.out.println(test);

        System.out.println(login + " " + password);
        return true;
    }

    @Override
    public void update(Object[] args) {
        String[] parameters = (String[]) args;

        if (!pcs_authentifier(parameters[0], parameters[1])) {
            showLoginFrame();
        }
    }
}
