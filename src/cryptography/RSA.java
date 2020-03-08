/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author matthewbelgre
 */
public class RSA {
   //e after calculations
  private BigInteger publicKey;
  //d after calculations
   private BigInteger privateKey;
   // n = p * q
   private BigInteger n;
   //random numbner generator
  private SecureRandom random;
  
  
  public RSA(){
      this.random = new SecureRandom();
  }
  
  public BigInteger encryptMessage(String message){
      return encrypt(this.publicKey, this.n, message);
  }
  
  public String decryptMessage(BigInteger cipherText){
      return this.decrypt(this.privateKey, this.n, cipherText);
      
  }
  private String decrypt(BigInteger d, BigInteger m, BigInteger cipherText){
      BigInteger messageInt = cipherText.modPow(d, m);
      return new String(messageInt.toByteArray());
  }
  //Will return a huge integer value
  private BigInteger encrypt(BigInteger e, BigInteger n, String message){
      //transform meassage into string of bytes
      byte[] messageBytes = message.getBytes();
      
      
      BigInteger messageInt = new BigInteger(messageBytes);
      
      //use modular arithmetic exponentiation messag * e mod n is the cipher text
      return messageInt.modPow(e, n);
  }
  
  public void generateKeys(int keyDigits){
      BigInteger p = BigInteger.probablePrime(keyDigits, random);
      
      BigInteger q = BigInteger.probablePrime(keyDigits, random);
      
      this.n = p.multiply(q);
      
      BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
      
      BigInteger e = generatePublicFactor(phi);
      
      BigInteger d = e.modInverse(phi);
      
      this.privateKey =d ;
      this.publicKey = e;
  }
  
  private BigInteger generatePublicFactor(BigInteger phi){
      BigInteger e = new BigInteger(phi.bitLength(), this.random);
      
      while(!e.gcd(phi).equals(BigInteger.ONE)){
          e = new BigInteger(phi.bitLength(), this.random);
      }
      return e;
  }
  
}
