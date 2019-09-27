package com.madmax.controller;

import com.madmax.controller.utils.Observer;
import com.madmax.model.MapP;
import com.madmax.view.auth.FrmAuth;
import com.madmax.view.file.FrmDecrypt;

public class Wkf_cpte implements Observer {
    private static final Wkf_cpte INSTANCE = new Wkf_cpte();

    private String userId = "";

    public static Wkf_cpte getInstance() {
        return INSTANCE;
    }

    public void showLoginFrame(boolean hasError) {
        FrmAuth frame = new FrmAuth(hasError);
        frame.addObserver(this);
        frame.setVisible(true);
    }

    private Wkf_cpte() {
    }

    private boolean pcs_authentifier(String login, String password) {
        String result = MapP.getInstance().selectIDbyLoginPassword(login, password);

        if (result == null) {
            return false;
        } else {
            this.userId = result;
        }

        return true;
    }

    @Override
    public void update(Object[] args) {
        String[] parameters = (String[]) args;

        if (!pcs_authentifier(parameters[0], parameters[1])) {
            showLoginFrame(true);
        } else {
            new FrmDecrypt().setVisible(true);
        }
    }

    public String getUserId() {
        return userId;
    }
}
