package com.madmax;

import com.madmax.controller.Wkf_cpte;
import com.madmax.controller.Wkf_decrypt;
import com.madmax.model.Decrypt;
import com.madmax.model.MapDic;

public class Main {
    public static void main(String[] args) {

        //Wkf_cpte.getInstance().showLoginFrame(false);
        String target = Wkf_decrypt.getInstance().testKey(Wkf_decrypt.placeHolder,"awqpaaaaaabz");
        System.out.println(Wkf_decrypt.getInstance().isWordFrench("Deunkeusheune"));

       /* while(true) {
            Wkf_decrypt.getInstance().testKey(target,Wkf_decrypt.getInstance().generateKeyFromLastAttempt() );
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
