package com.madmax.controller;


import com.madmax.model.Decrypt;
import com.madmax.model.Files;
import com.madmax.model.MapDic;

public class Wkf_decrypt {
    private String lastTestKey;
    private int nbTested;
    private static String firstKey = "aaaaaaaa"; //The first key to be tested and incremented
    private static String hint = "awqp"; //4 fixed letters that were given to us
    //public static String placeHolder ="Ceci est un texte de test sans accents, c'est vrai que ca va pour l'instant ca marche, parceque bientot ca va partir en torche, et là ca va barder tmTc";
    private final static Wkf_decrypt INSTANCE = new Wkf_decrypt();

    public static Wkf_decrypt getInstance() {
        return INSTANCE;
    }

    private Wkf_decrypt() {
        this.nbTested =0; //Number of keys tested
        this.lastTestKey = firstKey; //our first key tested, then we'll increment it to go forward                           /!\12 chars/!\
    }

    public boolean pcs_decrypter(String source_path, String destination_path) {
        boolean done = false;
       while(!done){
          String currentKey = generateKeyFromLastAttempt();
          testKeyOnFile(source_path,destination_path,currentKey);
        }
        return true;
    } //Main method, looks for a suitable key to decipher the message

    public void testKeyOnFile(String pathIn,String pathOut,String key){

        String data = Files.getInstance().getData(pathIn);
        String out = Decrypt.getInstance().decrypt(data,key);
        String[] words = getFirstWords(out);
        int frenchNess = rateMyFrench(words);
        if (frenchNess>2){
            saveKey(pathOut,data);
        } else {

        }
        out = "\n"+key +" "+frenchNess+" : "+out;
        System.out.println(out);
        nbTested++;

    } //tests a key and saves it if it looks like it works

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

    private void saveKey(String path, String data){ //saves a key that seems good in a file
        Files.getInstance().setData(path,data);

    }


    public int rateMyFrench(String[] words) {
        int length = words.length - 1;
        int correct = 0;
        int wrong = 0;
        for (int i = 0; i < length; i++) {
            System.out.println(words[i]);
            if ( isWordFrench(words[i]) ) {
                correct++;
            } else {
                wrong++;
            }
        }
        return correct;
    } //Counts the number of french words in an array

    private boolean isWordFrench(String word){ //Is a word french? this method returns the answer according to our "really reliable" dictionary
        String result = MapDic.getInstance().selectWord(word);
        if(result == null) {
            return false;
        }else{
            return true;
        }
    }
  
}
