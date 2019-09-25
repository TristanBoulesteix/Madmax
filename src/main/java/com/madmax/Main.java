package com.madmax;

import com.madmax.controller.Wkf_cpte;
import com.madmax.controller.Wkf_decrypt;
import com.madmax.model.Decrypt;

public class Main {
    public static void main(String[] args) {
      //Wkf_cpte.getInstance().showLoginFrame();
        Wkf_decrypt.getInstance().testKey(Wkf_decrypt.getInstance().testKey(Wkf_decrypt.placeHolder,Wkf_decrypt.getInstance().generateKeyFromLastAttempt()),"awqpaaaaaaab");

    }
}
