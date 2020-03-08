/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.math.BigInteger;

/**
 *
 * @author matthewbelgre
 */
public class ModularInverse {
   
    public BigInteger modularInverse(BigInteger a , BigInteger m){
       
        BigInteger inv = new BigInteger("0");
        
        //within the range [0, m-1]
        while(inv.compareTo(m) < 0){
            
            //check that if a*a-1 mod m == 1 is true or false
            if(a.multiply(inv).mod(m).equals(BigInteger.ONE)){
                return inv;
            }
            
            inv = inv.add(BigInteger.ONE);
        }
        System.out.println("There is no modular inverse (a is not coprime to m)");
        return null;
    }
}