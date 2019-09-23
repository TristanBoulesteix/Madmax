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

        for (char letter : data.toCharArray()) {
            int binaryLetter = letter;
            int binaryKeyLetter = key.charAt(keyIndex);

            int a = binaryLetter ^ binaryKeyLetter;
            System.out.println((char) a);
        }

        return builder.toString();
    }
}
