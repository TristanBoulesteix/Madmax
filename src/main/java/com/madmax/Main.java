package com.madmax;

import com.madmax.view.AuthFrame;

public class Main {
    public static void main (String[] args){
        System.out.println("Hello world !");
        AuthFrame.getInstance().setVisible(true);
    }
}
