package com.madmax.model;

import java.sql.ResultSet;

public class MapP {

    public String selectIDbyLoginPassword(String login, String password){

        CAD cadP = new CAD();
        String data = cadP.getRows("SELECT ID FROM utilisateur WHERE Login =\""+login+"\" AND Password =\""+password+"\";", "user");

        System.out.println(data);
        return data;
    }
}
