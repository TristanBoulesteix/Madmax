package com.madmax.controller;


import com.madmax.model.Decrypt;
import com.madmax.model.Files;
import com.madmax.model.MapDic;

public class WkfDecrypt {
    private int nbTested;
    private String lastTestKey;
    // The right key is : awqpmndfgtej // Test key : mndfgsta
    private static final String firstKey = "mndfgsta"; //The first key to be tested and incremented
    private static final String hint = "awqp"; //4 fixed letters that were given to us
    private final static WkfDecrypt INSTANCE = new WkfDecrypt();

    public static WkfDecrypt getInstance() {
        return INSTANCE;
    }

    private WkfDecrypt() {
        this.nbTested = 0;
        this.lastTestKey = firstKey; //our first key tested, then we'll increment it to go forward                           /!\12 chars/!\
    }

    public boolean pcs_decrypter(String source_path, String destination_path) {
        boolean done = false;
        while (!done) {
            String currentKey = generateKeyFromLastAttempt();
            testKeyOnFile(source_path, destination_path, currentKey);
        }
        return true;
    } //Main method, looks for a suitable key to decipher the message

    private void testKeyOnFile(String pathIn, String pathOut, String key) {
        String data = Files.getInstance().getData(pathIn);
        String out = Decrypt.getInstance().decrypt(data, key);
        String[] words = getFirstWords(out);
        int frenchNess = rateMyFrench(words);
        out = "\nkey N°" + nbTested + " " + key + " : " + frenchNess + "/5 : " + out;
        if (frenchNess > 2) {
            System.out.print("\nA potential key has been found, check the output file");
            saveKey(pathOut, out);
            System.out.println(out);
        }
        nbTested++;
    } //tests a key and saves it if it looks like it works

    private String generateKeyFromLastAttempt() {
        int length = lastTestKey.length();
        incrementChar(length - 1);
        return hint + lastTestKey;
    } //generates a new key to test

    private void incrementChar(int n) { //increments the unknown part of the key
        if ((lastTestKey.charAt(n)) == 'z') {
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < lastTestKey.length(); i++) {
                if (i == n) {
                    out.append('a');
                } else {
                    out.append(lastTestKey.charAt(i));
                }

            }
            lastTestKey = out.toString();
            incrementChar(n - 1);

        } else {
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < lastTestKey.length(); i++) {
                if (i == n) {
                    out.append((char) (((int) lastTestKey.charAt(n)) + 1));
                } else {
                    out.append(lastTestKey.charAt(i));

                }

            }
            lastTestKey = out.toString();


        }
    } // increments individual chars in the key as needed (if a char is "z", the one before it goes up one char)

    private String[] getFirstWords(String text) { //Returns the 5 first words of a string in an array, after removing Uppercase chars and punctuation
        return text.split(" ", 6);
    } //Saves the first words of a string

    private void saveKey(String path, String data) { //saves a key that seems good in a file
        Files.getInstance().setData(path, data);
    }


    private int rateMyFrench(String[] words) {
        int length = words.length - 1;
        int correct = 0;
        int wrong = 0;
        for (int i = 0; i < length; i++) {
            if (isWordFrench(words[i])) {
                correct++;
            } else {
                wrong++;
            }
        }
        return correct;
    } //Counts the number of french words in an array

    private boolean isWordFrench(String word) { //Is a word french? this method returns the answer according to our "really reliable" dictionary
        if (isAlpha(word)) {
            String result = MapDic.getInstance().selectWord(word);
            if (result != null) {
                return true;
            }
        }
        return false;
    }

    private boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

}
