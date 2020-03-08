/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.util.Map;

/**
 *
 * @author matthewbelgre
 */
public class CaesarCipher {

    private int KEY;
    private FrequencyAnalysis fa = new FrequencyAnalysis();

    public CaesarCipher(int key) {
        this.KEY = key;
    }

    public String encrypt(String plainText) {
        //the encrypted message
        String cipherText = "";
        //We make the algorithm case sensitive        
        //Loop through all characters in the message
        for (int i = 0; i < plainText.length(); i++) {
            char character = plainText.charAt(i);

            //Find the index of the character in the alphabet
            int charIndex = (int) character;

            //Caesar shifts according to key
            //Use modular arithmeticto transform the values within range [0, letter in the alphabet]
            //with ascii set
            int encryptedIndex = Math.floorMod(charIndex + KEY, 255);

            //keep appending encrypted charcater to cipher text
            char c = (char) encryptedIndex;
            cipherText = cipherText + c;
        }

        return cipherText;
    }

    public String decrypt(String cipherText) {
        //the decrypted message
        String plainText = "";

        for (int i = 0; i < cipherText.length(); i++) {
            char character = cipherText.charAt(i);

            //Find the index of the character in the alphabet
            int charIndex = (int) character;

            //Caesar decrypts according to key
            //Use modular arithmeticto transform the values within range [0, letter in the alphabet]
            int decryptedIndex = Math.floorMod(charIndex - KEY, 255);

            //keep appending decrypted charcater to cipher text
            char c = (char) decryptedIndex;
            plainText = plainText + c;

        }
        return plainText;
    }

    public String decrypt(String cipherText, int key) {
        //the decrypted message
        String plainText = "";

        for (int i = 0; i < cipherText.length(); i++) {
            char character = cipherText.charAt(i);

            //Find the index of the character in the alphabet            
            int charIndex = (int) character;

            //Caesar decrypts according to key
            //Use modular arithmeticto transform the values within range [0, letter in the alphabet]
            int decryptedIndex = Math.floorMod(charIndex - key, 255);

            //keep appending decrypted charcater to cipher text            
            char c = (char) decryptedIndex;
            plainText = plainText + c;
        }
        return plainText;
    }

    public String CaesarCipherBruteFrequency(String cipher) {
        LanguageDetector l = new LanguageDetector();
        for (int i = 0; i < 26; i++) {
            if (l.isTextEnglish(this.decrypt(cipher, i))) {
                return "The key is: " + i + "  = " + this.decrypt(cipher, i);

            }

        }
        return "Cant be found";
    }

    public String CaesarCipherBrute(String cipher) {
        String message = "";
        for (int i = 0; i < 255; i++) {
            message += "The key is: " + i + "  = " + this.decrypt(cipher, i) + "\n";

        }
        return message;

    }

    public String CaesarCipherFrequency(String cipher) {
        //A map that store the character-frequency pairs
        Map<Character, Integer> letterFrequencies = fa.analyse(cipher);

        //a simple O(N) linear search to find the character with maximum frequency
        Map.Entry<Character, Integer> maxEntry = null;

        for (Map.Entry<Character, Integer> entry : letterFrequencies.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        //we get the most frequent letter in the cipher text
        char mostFrequentChar = maxEntry.getKey();

        //key ~ [most frequent letter in the cipher text - most frequent letter used in englis]
        //the most common letter is the whitespace 
        //With generic 26 letter ALPHABET defined as variable
        //int approximateKey = ALPHABET.indexOf(mostFrequentChar)- ALPHABET.indexOf('E');
        int charIndex = (int) mostFrequentChar;
        int approximateKeyE = charIndex - (char) 'e';
        int approximateKeyA = charIndex - (char) 'a';
        int approximateKeyR = charIndex - (char) 'r';
        int approximateKeyI = charIndex - (char) 'i';
        int approximateKeyO = charIndex - (char) 'o';

        return String.format("%s%s%n%s%n%s%n%n%s%s%n%s%n%s%n%n%s%s%n%s%n%s%n%n%s%s%n%s%n%s%n%n%s%s%n%s%n%s",
                "The key for (e) is: ", approximateKeyE,
                "THE DECRYPTED MESSAGE IS:",
                this.decrypt(cipher, approximateKeyE),
                "The key for (a) is: ", approximateKeyA,
                "THE DECRYPTED MESSAGE IS:",
                this.decrypt(cipher, approximateKeyA),
                "The key for (r) is: ", approximateKeyR,
                "THE DECRYPTED MESSAGE IS:",
                this.decrypt(cipher, approximateKeyR),
                "The key for (i) is: ", approximateKeyI,
                "THE DECRYPTED MESSAGE IS:",
                this.decrypt(cipher, approximateKeyI),
                "The key for (o) is: ", approximateKeyO,
                "THE DECRYPTED MESSAGE IS:",
                this.decrypt(cipher, approximateKeyO)
        );

    }

}
