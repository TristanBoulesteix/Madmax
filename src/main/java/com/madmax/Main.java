package com.madmax;

import com.madmax.model.Decrypt;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world !");
        Decrypt.getInstance().decrypt("toto", "key");
    }
}
