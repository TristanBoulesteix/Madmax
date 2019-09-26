package com.madmax.model;

public class MapP {
    private static final MapP INSTANCE = new MapP();

    public static MapP getInstance() {
        return INSTANCE;
    }

    private MapP() { }

    public String selectIDbyLoginPassword(String login, String password){

        CAD cadP = new CAD();

        return cadP.getRows("SELECT ID_utilisateur FROM utilisateur WHERE Login =\""+login+"\" AND Password =\""+password+"\";", "user");
    }
}
