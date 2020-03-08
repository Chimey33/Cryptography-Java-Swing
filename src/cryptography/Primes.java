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
public class Primes {
    
    public boolean naivePrimality(int num){
        if(num <= 2){
            return false;
        }else if(num % 2 == 0){
            return false;
        }
        for(int i = 3; i < Math.floor(Math.sqrt(num)); i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    
     public void factorize(int num) {
 
		//the same reasoning as we discussed with primality test
		int limit = (int) Math.floor(Math.sqrt(num));
		
		//let's try to find the factors
		//note: if the given number has small factors: we can find it quite fast (!!!)
		for(int i=2;i<limit;i++) {
			if(num%i==0) {
				System.out.println("Factors: ["+i+","+num/i+"]");
			}
		}
}
}
