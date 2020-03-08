/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author matthewbelgre
 */
public class Cryptography {

    /**
     * @param args the command line arguments
     * @throws java.security.NoSuchAlgorithmException
     * @throws javax.crypto.NoSuchPaddingException
     * @throws java.security.InvalidKeyException
     * @throws javax.crypto.IllegalBlockSizeException
     * @throws javax.crypto.BadPaddingException
     * @throws java.io.UnsupportedEncodingException
     */

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
//
 RSA test = new RSA();
 test.generateKeys(2500);
    String message = "Experienced German teachers prepared easyExperienced German teachers prepared easy articles and simple conversations in German for beginners (level A1 and A2) and intermediates (level B1 and B2) to evaluate your comprehension and leave you feeling challenged and satisfied. Just click, read, and then answer the multiple-choice questions of the associated test. Your answers get evaluated immediately, and you are ready to move on to the next exercise. It's easy, enjoyable and free.";
        //System.out.println(test.encrypt(message));
        BigInteger cipher = test.encryptMessage(message);
        System.out.println(test.decryptMessage(cipher));

    //String cipher = test.encrypt(message);
   


//new CryptographyGUI().setVisible(true);;




    }
    
    
   
            
}
