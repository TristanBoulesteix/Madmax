package com.madmax.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapDic {

    public String selectWord(String word) {
        CAD cadP = new CAD();
        String data = cadP.getRows("SELECT Mot FROM dictionnaire WHERE Mot =\""+word+"\";", "dico");
        System.out.println(data);
        return data;
    }

}
