package com.madmax.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class MapDic {
    public static MapDic instance;

    public static MapDic getInstance(){
        if(instance == null){
            return new MapDic();
        }
        else return instance;
    }

    public String selectWord(String word) {
        CAD cadP = new CAD();
        String data = cadP.getRows("SELECT Mot FROM dictionnaire WHERE Mot =\""+word+"\";", "dico");

        return data;
    }

}
