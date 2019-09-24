package com.madmax;

import com.madmax.controller.Wkf_decrypt;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world !");

        while (true) {
            System.out.println(Wkf_decrypt.getInstance().generateKeyFromLastAttempt());

        }
        
    }
}
