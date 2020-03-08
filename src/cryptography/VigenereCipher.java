/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/**
 *
 * @author matthewbelgre
 */
public class VigenereCipher {

   public String encrypt(String plainText, String key){
       //text we want to encrypt
       String cipherText = "";
       //index for key
       int keyIndex = 0;
       
       for(int i =0; i < plainText.length(); ++i){
           char c = plainText.charAt(i);
           //number of shifts = Number of char in the alphabet + index of char in key
                      
            int charIndex = (int)c;
            int index = Math.floorMod(charIndex + (int)key.charAt(keyIndex), 255);
           
           char newChar = (char)index;
           cipherText = cipherText + newChar;
           //increment key index to use for next letter
           keyIndex++;
           //Once we reach the end of key, reset the index
           if(keyIndex == key.length()){
               keyIndex = 0;
           }
       }
       return cipherText;
   } 
    
     public String decrypt(String cipherText, String key){
       //text we want to encrypt      
       String plainText = "";
       //index for key
       int keyIndex = 0;
       
       for(int i =0; i < cipherText.length(); ++i){
           char c = cipherText.charAt(i);
           
           int charIndex = (int)c;
            int index = Math.floorMod(charIndex - (int)key.charAt(keyIndex), 255);
           
           
           char newChar = (char)index;
           plainText = plainText + newChar;
           //increment key index to use for next letter
           keyIndex++;
           //Once we reach the end of key, reset the index
           if(keyIndex == key.length()){
               keyIndex = 0;
           }
       }
       return plainText;
   } 
}
