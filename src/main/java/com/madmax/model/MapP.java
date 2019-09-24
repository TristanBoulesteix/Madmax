package com.madmax.model;

public class MapP {
    private static final MapP INSTANCE = new MapP();

    public static MapP getInstance() {
        return INSTANCE;
    }

    private MapP() { }

    public String selectIDbyLoginPassword(String login, String password){

        CAD cadP = new CAD();
        String data = cadP.getRows("SELECT ID FROM utilisateur WHERE Login =\""+login+"\" AND Password =\""+password+"\";", "user");

        System.out.println(data);
        return data;
    }
}
