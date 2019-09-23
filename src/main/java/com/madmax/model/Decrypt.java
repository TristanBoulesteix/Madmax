package com.madmax.model;

public class Decrypt {
    private static final Decrypt INSTANCE = new Decrypt();

    public static Decrypt getInstance() {
        return INSTANCE;
    }

    private Decrypt() {
    }

    public String decrypt(String data, String key) {
        StringBuilder builder = new StringBuilder();

        for (char letter : data.toCharArray()) {

        }

        return builder.toString();
    }
}
