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

        int keyIndex = 0;

        for (int i = 0; i < data.length(); i++) {
            char binaryLetter = data.charAt(i);
            char binaryKeyLetter = key.charAt(keyIndex);
            builder.append((char) (binaryLetter ^ binaryKeyLetter));

            keyIndex++;

            if (keyIndex == key.length()) keyIndex = 0;
        }

        return builder.toString();
    }
}
