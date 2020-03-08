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
 public class DiscreteLogarithm {
 
	//discrete logarithm is the inverse of modular exponentiation
	public BigInteger discreteLogarithm(BigInteger a, BigInteger b, BigInteger m) {
		
		//we try all the values of the exponent one by one until we find it
		BigInteger c = new BigInteger("1");
		
		//if b^c mod m = a it means we find the right c exponent
		while(b.modPow(c,m).compareTo(a)!=0)
			c = c.add(BigInteger.ONE); //if the exponent is not right we consider the next one
		
		return c;
	}
	
	//modular exponentiation: we just have to use the formual (b^c) mod m
	public BigInteger modularExponentiation(BigInteger b, BigInteger c, BigInteger m) {
		return b.modPow(c, m);
	}	
}