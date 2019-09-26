package com.madmax.model;

public class MapDic {
    private static MapDic INSTANCE = new MapDic();

    public static MapDic getInstance() {
        return INSTANCE;
    }

    private MapDic() {

    }

    public String selectWord(String word) {
        return CAD.getInstance().getRows("SELECT Mot FROM dictionnaire WHERE Mot =\"" + word + "\";", "dico");
    }

}
