package com.madmax;

import com.madmax.controller.Wkf_decrypt;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world !");
        Wkf_decrypt.getInstance().getFirstWords(Wkf_decrypt.placeHolder);
        while (true){
            System.out.println(Wkf_decrypt.getInstance().generateKeyFromLastAttempt());
        }
        
    }
}
