package com.madmax.controller;

public class Wkf_cpte {
    private static final Wkf_cpte INSTANCE = new Wkf_cpte();

    public static Wkf_cpte getInstance() {
        return INSTANCE;
    }

    private Wkf_cpte() {}

    public boolean pcs_authentifier(String login, String password) {
        return true;
    }
}
