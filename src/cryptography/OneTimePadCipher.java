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
public class OneTimePadCipher {

    public String keyString = "";
    int[] key;

    public OneTimePadCipher(int[] k) {
        this.key = k;
    }

    public String encrypt(String plainText) {
        String cipherText = "";

        for (int i = 0; i < plainText.length(); i++) {

            int keyIndex = key[i];

            int characterIndex = (int) plainText.charAt(i);
            char c = (char) Math.floorMod(characterIndex + keyIndex, 255);

            cipherText = cipherText + c;
        }
        return cipherText;
    }

    public String decrypt(String cipherText, int[] key) {
        String plainText = "";

        for (int i = 0; i < cipherText.length(); i++) {

            int keyIndex = key[i];

            int characterIndex = (int) cipherText.charAt(i);

            char c = (char) Math.floorMod(characterIndex - keyIndex, 255);
            plainText = plainText + c;
        }
        return plainText;
    }

    public String getKeyString() {
        for (int i = 0; i < key.length; i++) {
            keyString += String.valueOf(key[i]);
        }
        return keyString;
    }

}
