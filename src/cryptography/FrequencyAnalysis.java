/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author matthewbelgre
 */
public class FrequencyAnalysis {
//public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

   //the method for the frequency analysis
  public Map<Character, Integer> analyse(String text){
      
      //text = text.toUpperCase();
      
      //use a dictionary to store the letter frequency pair
      Map<Character, Integer> letterFrequencies = new HashMap<>();
      
      //initialise the dictionary with a 0 frequency
//      for(int i = 0; i < ALPHABET.length(); ++i)
//          letterFrequencies.put(ALPHABET.charAt(i), 0);
      
        for(int i = 0; i < 255; i++)
            letterFrequencies.put((char)(i), 0);
          for(int a = 0; a < text.length(); a++){
          
              char c = text.charAt(a);
          
              //we keep incrementing the occurences of the given letter if it is present in ALPHABET
                
             // if(ALPHABET.indexOf(c) != -1){
                   if((char)c != -1){
                    letterFrequencies.put(c, letterFrequencies.get(c) +1);
                }
               }
            
       return letterFrequencies;
  }  
}
