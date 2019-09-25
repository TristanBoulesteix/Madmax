package com.madmax.controller;


import com.madmax.model.Decrypt;
import com.madmax.model.Files;

public class Wkf_decrypt {

    private String lastTestKey;
    private int nbTested;
    private int nextIndex;
    private String hint = "awqp";
    public static String placeHolder = "boNjouR, le java est un langage de programmation interessant";
    private final static Wkf_decrypt INSTANCE = new Wkf_decrypt();

    public static Wkf_decrypt getInstance() {
        return INSTANCE;
    }

    private Wkf_decrypt() {
        this.nbTested =0;
        this.lastTestKey = "aaaaaaaa"; //ou first key tested, then we'll increment it to go forward                           /!\12 chars/!\
    }

    public boolean pcs_decrypter(String source_path, String destination_path) {
        String data = Decrypt.getInstance().decrypt(Files.getInstance().getData(source_path), "key");
        Files.getInstance().setData(destination_path, data);
        return true;
    }


    public String generateKeyFromLastAttempt() { // 97 to 122
        int length = lastTestKey.length();
        incrementChar(length-1);
        return hint+lastTestKey;
    }

    private void incrementChar(int n){
        if  ( (lastTestKey.charAt(n))== 'z'){
            String out="";
            for(int i=0;i<lastTestKey.length();i++){
                if (i==n){
                    out = out+'a';
                }
                else {
                    out = out + lastTestKey.charAt(i);

                }

            }
            lastTestKey = out;
            incrementChar(n-1);
        } else {

            String out="";
            for(int i=0;i<lastTestKey.length();i++){
                if (i==n){
                    out = out+(char)(((int)lastTestKey.charAt(n))+1);
                }
                else {
                    out = out + lastTestKey.charAt(i);

                }

            }
            lastTestKey = out;



        }
    }

    public String[] getFirstWords(String text){ //Returns the 5 first words of a string in an array, after removing Uppercase chars and punctuation

        String clean = (text.toLowerCase()).replaceAll("[^a-z]+", " ");
        String[] words = clean.split(" ",5);
        return words;
    }
  
}
