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
public class AffineCipher {
 public int a;
 public int b;
//static int a = 17; 
//static int b = 20; 
public AffineCipher(int a, int b){
    this.a = a;
    this.b = b;
}
  static int findGCD(int a, int b) {
        //int counter =1;
        int one, two;
        //finds highest value number
        if (a > b) {
            one = a;
            two = b;
        } else {
            one = b;
            two = a;
        }
        //finds modulo of highest divide lowest
        int remainder = one % two;
        //if remainder is zero set it to the remainder of the last step
        if (remainder == 0) {

            return two;
        }
        //other use recursion 
        return findGCD(two, remainder);
    }
  
    public String encrypt(char[] plaintext){ 
        String cipher = ""; 
        for (int i = 0; i < plaintext.length; i++){ 
            /* applying encryption formula ( a x + b ) mod m 
            here x is plaintext[i] and m is 254 (All ascii characters)  */ 
             cipher = cipher + (char)Math.floorMod((a * plaintext[i]) + b, 254);

        } 
        return cipher; 
    } 
  
    public String decrypt(String cipher)  { 
        String plaintext = ""; 
        int a_inverse = 0; 
        int flag = 0; 
     //Find a^-1 (the multiplicative inverse of a  
        //in the group of integers modulo m.)  
        for (int i = 0; i < 254; i++){ 
            flag = (a * i) % 254; 
            // Check if (a*i)%254 == 1, 
            // then i will be the multiplicative inverse of a 
            if (flag == 1){ 
                a_inverse = i; 
            } 
        } 
        for (int i = 0; i < cipher.length(); i++)  { 
            /*Applying decryption formula a^-1 ( x - b ) mod m  
            here x is cipher[i] and m is 254*/ 
            
            plaintext = plaintext + (char)Math.floorMod(( a_inverse * (cipher.charAt(i) - b)), 254);

        } 
  
        return plaintext; 
    } 

            
}
