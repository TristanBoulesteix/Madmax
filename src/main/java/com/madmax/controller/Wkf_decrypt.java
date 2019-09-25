package com.madmax.controller;


import com.madmax.model.Decrypt;
import com.madmax.model.Files;
import com.madmax.model.MapDic;

public class Wkf_decrypt {
    private String lastTestKey;
    private int nbTested;

    private String hint = "awqp";
    public static String placeHolder ="Ceci est un texte de test sans accents, c'est vrai que ca va pour l'instant ca marche, parceque bientot ca va partir en torche, et là ca va barder tmTc";
    private final static Wkf_decrypt INSTANCE = new Wkf_decrypt();

    public static Wkf_decrypt getInstance() {
        return INSTANCE;
    }

    private Wkf_decrypt() {
        this.nbTested =0; //Number of keys tested
        this.lastTestKey = "aaaaaaaa"; //our first key tested, then we'll increment it to go forward                           /!\12 chars/!\
    }

    public boolean pcs_decrypter(String source_path, String destination_path) {
        String data = Decrypt.getInstance().decrypt(Files.getInstance().getData(source_path), "key");
        Files.getInstance().setData(destination_path, data);
        return true;
    } //Main method, looks for a suitable key to decipher the message


    public String generateKeyFromLastAttempt() {
        int length = lastTestKey.length();
        incrementChar(length-1);
        return hint+lastTestKey;
    } //generates a new key to test

    private void incrementChar(int n){ //increments the unknown part of the key
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
    } // increments individual chars in the key as needed (if a char is "z", the one before it goes up one char)

    public String[] getFirstWords(String text){ //Returns the 5 first words of a string in an array, after removing Uppercase chars and punctuation

        String[] words = text.split(" ",6);

        return words;
    } //Saves the first words of a string

    public String testKey(String data,String key){
        System.out.println(key);
        String out = Decrypt.getInstance().decrypt(data,key);
        String[] words = getFirstWords(out);
        System.out.println(out); // test, à remplacer
        return(out);
    } //tests a key and saves it if it looks like it works


    //TO DO: une fonction qui compte les mots fr et les erreurs, et qui choisi de report la clé ou non.\\

    public boolean isWordFrench(String word){
        String result = MapDic.getInstance().selectWord(word);
        if(result == null) {
            return false;
        }else{
            return true;
        }
    } //Is a word french? this method returns the answer according to our "really reliable" dictionary
  
}
