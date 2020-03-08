/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author matthewbelgre
 */
public class AdvancedEncryptionStandard {
       public String encrypt(String plainText, SecretKey key) throws NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        
    
    byte[] cipherText = null;
    
    try {
    Cipher encryptionCipher = Cipher.getInstance("AES");
    encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
    
    //convert plaintext into bytes
    byte[] bytes = plainText.getBytes();
    
    //encryption
    cipherText = encryptionCipher.doFinal(bytes);
    
    //represent and encode bytes sequence as string
    cipherText = Base64.getEncoder().encode(cipherText);
    }catch (NoSuchAlgorithmException | NoSuchPaddingException | 
            InvalidKeyException | IllegalBlockSizeException | 
            BadPaddingException e){
    }
    return new String(cipherText);
    }
       
     public String decrypt(String cipherText, SecretKey key) throws NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        
    
    byte[] decrypted = null;
    
    try {
    Cipher decryptionCipher = Cipher.getInstance("AES");
    decryptionCipher.init(Cipher.DECRYPT_MODE, key);
    
    //convert plaintext into bytes
    byte[] bytesDecrypted = Base64.getDecoder().decode(cipherText.getBytes());
    
    //encryption
    decrypted = decryptionCipher.doFinal(bytesDecrypted);
    
    //represent and encode bytes sequence as string
    return new String(decrypted,"UTF8");
    }catch (NoSuchAlgorithmException | NoSuchPaddingException 
            | InvalidKeyException | IllegalBlockSizeException | 
            BadPaddingException e){
    }
    return null;
    }
}
