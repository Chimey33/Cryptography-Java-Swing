/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.util.Random;

/**
 *
 * @author matthewbelgre
 */
public class RandomSequenceGenerator {
    private Random random;
    public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String key = "";
    
    public RandomSequenceGenerator(){
        this.random = new Random();
    }
    //pseudo random generator
    public int[] generate(int n){
        int[] randomSequence = new int[n];
      
        for(int i = 0; i < n; i++){
            randomSequence[i] = random.nextInt(ALPHABET.length());
            key += String.valueOf(randomSequence[i]);
        }
      
        
        
        return randomSequence;
    }
    
    public String getKey(){
        return this.key;
    }
    
}
