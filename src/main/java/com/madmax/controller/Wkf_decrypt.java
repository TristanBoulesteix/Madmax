package com.madmax.controller;


import com.madmax.model.Decrypt;
import com.madmax.model.Files;

public class Wkf_decrypt {
    private final static Wkf_decrypt INSTANCE = new Wkf_decrypt();

    public static Wkf_decrypt getInstance() {
        return INSTANCE;
    }

    private Wkf_decrypt() {
    }

    public boolean pcs_decrypter(String source_path, String destination_path) {
        String data = Decrypt.getInstance().decrypt(Files.getInstance().getData(source_path), "key");
        Files.getInstance().setData(destination_path, data);
        return true;
    }

    private String generateKey() {
        return null;
    }
}
