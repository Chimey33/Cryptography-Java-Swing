/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author matthewbelgre
 */
public class EuclideanAlgorithm {

    private static Map<Integer, String> euclidMap = new HashMap<>();
    private static int counter = 1;

    public int findGCD(int a, int b) {
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
        int divisor = one / two;
        String mapEntry = Integer.toString(remainder) + "=" + Integer.toString(one) + "-" + Integer.toString(two) + "(" + Integer.toString(divisor) + ")";
        //String mapEntry = Integer.toString(one)+"="+Integer.toString(two) +"("+Integer.toString(divisor) + ")"+Integer.toString(remainder);
        euclidMap.put(counter, mapEntry);
        //if remainder is zero set it to the remainder of the last step
        if (remainder == 0) {
            counter = 1;

            return two;
        }
        counter++;
        //other use recursion 
        return findGCD(two, remainder);
    }

    public Map<Integer, String> getEuclidMap() {
        return euclidMap;
    }

    public void printMap() {
        for (int i = 1; i < euclidMap.size(); i++) {
            System.out.println(euclidMap.get(i));
        }
    }
//
//    public void extendedEuclidean() {
//        String test = "";
//        for (int i = euclidMap.size() - 1; i > 1; i--) {
//            //gets last entry from map (starting)
//            String first = euclidMap.get(i);
//            //removes = size
//            String startingValue = first.substring(first.indexOf("=") + 1);
//            System.out.println(startingValue + "   start....");
//            String nextSub = "";
//            if (startingValue.charAt(0) != '-') {
//
//                if (startingValue.charAt(0) == '+') {
//                    nextSub = startingValue.substring(startingValue.indexOf(0) + 1, startingValue.indexOf("("));
//                    nextSub = nextSub.replace("+", "");
//                    System.out.println(nextSub + "       next sub value help me");
//                } else {
//
//                    nextSub = startingValue.substring(startingValue.indexOf(0) + 1, startingValue.indexOf("-"));
//                    System.out.println(nextSub + "       next sub value help ma");
//                }
//
//            } else {
//                nextSub = startingValue.substring(startingValue.indexOf("-") + 1, startingValue.indexOf("("));
//                System.out.println(nextSub + "       next sub value");
//            }
//            //finds the value between the - and (
//            String numberToReplace = "";
//            //numberToReplace = startingValue.substring(startingValue.indexOf("-") + 1, startingValue.indexOf("("));
//
//            if (startingValue.charAt(0) != '-') {
//                if (startingValue.charAt(0) == '+') {
//                    numberToReplace = startingValue.substring(startingValue.indexOf("-") + 1, startingValue.indexOf("("));
//
//                } else {
//                    numberToReplace = startingValue.substring(startingValue.indexOf("-") + 1, startingValue.indexOf("("));
//                }
//            } else if (startingValue.charAt(0) == '-') {
//                numberToReplace = startingValue.substring(startingValue.indexOf("+") + 1);
//                numberToReplace = numberToReplace.substring(0, numberToReplace.indexOf("("));
//
//            }
//            System.out.println(numberToReplace + "   number that we substitue for....");
//
////gets next value from map (-1)
//            String next = euclidMap.get(i - 1);
//            System.out.println(next + "      substitute value that will be used");
//
//            String getReplacementValue = euclidMap.get(i - 1).replace(numberToReplace + "=", "");
//
//            System.out.println(getReplacementValue + "   value with = removed ....");
//
//            if (startingValue.contains(nextSub + "(")) {
//                String bracket1 = startingValue.substring(startingValue.indexOf("(") + 1, startingValue.indexOf(")"));
//                System.out.println(bracket1 + "   first bracket value");
//
//                String bracket2 = getReplacementValue.substring(getReplacementValue.indexOf("(") + 1, getReplacementValue.indexOf(")"));
//                System.out.println(bracket2 + "   second bracket value....");
//
//                String multiplier1 = startingValue.substring(startingValue.indexOf(numberToReplace + "("));
//                multiplier1 = multiplier1.replace(numberToReplace, "");
//                multiplier1 = multiplier1.replace("(", "");
//                multiplier1 = multiplier1.replace(")", "");
//
//                System.out.println(multiplier1 + "         multi");
//
//                //find the values of the two brackets and adds them or leaves them
//                int bracket1Int = Integer.parseInt(bracket1);
//                int bracket2Int = Integer.parseInt(bracket2);
//
//                String subNewValueIn = startingValue.replace(numberToReplace + "(" + multiplier1 + ")", "[" + getReplacementValue + "]" + multiplier1);
//
//                System.out.println(subNewValueIn + "      new string......");
////            
////            String multiplier = subNewValueIn.substring(subNewValueIn.indexOf("]") +1 );
//////            
//////            System.out.println(multiplier + "        multiplier....."); 
//                String multiplier = subNewValueIn.substring(subNewValueIn.indexOf("]") + 1);
//
//                System.out.println(multiplier + "        multiplier.....");
//
//                String getMulValue = getReplacementValue.substring(getReplacementValue.indexOf(0) + 1, getReplacementValue.indexOf("-"));
//
//                System.out.println(getMulValue + "      number.........");
//
//                String replaceFirst = "";
//                if (!subNewValueIn.contains(getMulValue + "(")) {
//                    replaceFirst = subNewValueIn.replace("[" + getMulValue, getMulValue + "(" + multiplier + ")");
//                } else if (subNewValueIn.contains(getMulValue + "(")) {
//                    String mul = subNewValueIn.substring(subNewValueIn.indexOf(getMulValue + "(" + 1), subNewValueIn.indexOf(")"));
//                    int brack1 = Integer.parseInt(mul);
//                    int brack2 = Integer.parseInt(multiplier);
//                    String newValue = String.valueOf(brack1 * brack2);
//                    replaceFirst = subNewValueIn.replace("[" + getMulValue, getMulValue + "(" + newValue + ")");
//                }
//
//                System.out.println(replaceFirst + "         testing.......");
//
//                String getBrack = replaceFirst.substring(replaceFirst.indexOf(nextSub + "(", replaceFirst.indexOf(")")));
//
//                getBrack = getBrack.replace(nextSub, "");
//                getBrack = getBrack.replace("(", "");
//                getBrack = getBrack.replace(")", "");
//                getBrack = getBrack.replace("]" + multiplier, "");
//                System.out.println(getBrack + "         testing.......");
//                //getBrack = getBrack.replace(multiplier, "");
//
//                System.out.println(getBrack);
//                int brack1 = Integer.parseInt(getBrack);
//                int brack2 = Integer.parseInt(multiplier);
//                String newValue = String.valueOf(brack1 * brack2);
//                String incrementedValue = String.valueOf(brack1 * brack2 + 1);
//                String replaceSecond = replaceFirst.replace(nextSub + "(" + getBrack + ")]" + multiplier, nextSub + "(" + newValue + ")");
//                System.out.println(replaceSecond + "         replaceSecond");
//
//                String increment = replaceSecond.replaceFirst(nextSub, "");
//                increment = increment.replace(nextSub + "(" + newValue + ")", nextSub + "(" + incrementedValue + ")");
//
//                System.out.println(increment + "      check where i am......");
//                increment = increment.replace("-(" + bracket1 + ")", "");
//
////                System.out.println("first char " + increment.charAt(0));
////               if(increment.charAt(0) == '+'){
////                String swap1 = increment.substring(increment.indexOf("+"),increment.indexOf("-"));
////                   System.out.println(swap1 + "      first half");
////                String swap2 = increment.substring(increment.indexOf("-"),increment.length());
////                System.out.println(swap2 + "      second half");
////                increment = swap2 + swap1;
//////                increment = increment.replace("-", "+");
//////                increment = "-" + increment;
////            }
//                increment = nextSub + "=" + increment;
//
//                System.out.println(increment + "     this is the final value.....");
//                euclidMap.replace(i - 1, increment);
//
//            } else {
//                String bracket1 = startingValue.substring(startingValue.indexOf("(") + 1, startingValue.indexOf(")"));
//                System.out.println(bracket1 + "   first bracket value");
//
//                String bracket2 = getReplacementValue.substring(getReplacementValue.indexOf("(") + 1, getReplacementValue.indexOf(")"));
//                System.out.println(bracket2 + "   second bracket value....");
//
//                //find the values of the two brackets and adds them or leaves them
//                int bracket1Int = Integer.parseInt(bracket1);
//                int bracket2Int = Integer.parseInt(bracket2);
//
//                String subNewValueIn = startingValue.replace(numberToReplace + "(" + bracket1Int + ")", "[" + getReplacementValue + "]" + bracket1Int);
//
//                System.out.println(subNewValueIn + "      new string......");
//
//                String multiplier = subNewValueIn.substring(subNewValueIn.indexOf("]") + 1);
//
//                System.out.println(multiplier + "        multiplier.....");
//
//                String getMulValue = getReplacementValue.substring(getReplacementValue.indexOf(0) + 1, getReplacementValue.indexOf("-"));
//
//                System.out.println(getMulValue + "      number.........");
//
//                String replaceFirst = "";
//                if (!subNewValueIn.contains(getMulValue + "(")) {
//                    replaceFirst = subNewValueIn.replace("[" + getMulValue, getMulValue + "(" + multiplier + ")");
//                } else if (subNewValueIn.contains(getMulValue + "(")) {
//                    String mul = subNewValueIn.substring(subNewValueIn.indexOf(getMulValue + "(" + 1), subNewValueIn.indexOf(")"));
//                    int brack1 = Integer.parseInt(mul);
//                    int brack2 = Integer.parseInt(multiplier);
//                    String newValue = String.valueOf(brack1 * brack2);
//                    replaceFirst = subNewValueIn.replace("[" + getMulValue, getMulValue + "(" + newValue + ")");
//                }
//
//                System.out.println(replaceFirst + "         testing.......");
//
//                String getBrack = replaceFirst.substring(replaceFirst.indexOf(nextSub + "(", replaceFirst.indexOf(")")));
//
//                getBrack = getBrack.replace(nextSub, "");
//                getBrack = getBrack.replace("(", "");
//                getBrack = getBrack.replace(")", "");
//                getBrack = getBrack.replace("]" + multiplier, "");
//                System.out.println(getBrack + "         testing.......");
//                //getBrack = getBrack.replace(multiplier, "");
//
//                System.out.println(getBrack);
//                int brack1 = Integer.parseInt(getBrack);
//                int brack2 = Integer.parseInt(multiplier);
//                String newValue = String.valueOf(brack1 * brack2);
//                String incrementedValue = String.valueOf(brack1 * brack2 + 1);
//                String replaceSecond = replaceFirst.replace(nextSub + "(" + getBrack + ")]" + multiplier, nextSub + "(" + newValue + ")");
//                System.out.println(replaceSecond + "         replaceSecond");
//                String increment = replaceSecond.replaceFirst(nextSub, "");
//                increment = increment.replace(nextSub + "(" + newValue + ")", nextSub + "(" + incrementedValue + ")");
//
//                System.out.println(increment);
//
//                if (increment.charAt(0) == '-') {
//                    increment = increment.replaceFirst("-", "");
//                    increment = increment.replace("-", "+");
//                    increment = "-" + increment;
//                } else if (increment.charAt(0) != '-') {
//                    //removeNext = "-" + removeNext;
//                    increment = increment.replace("+", "-");
//                }
//                increment = nextSub + "=" + increment;
//
//                System.out.println(increment + "     this is the final value.....");
////            System.out.println("");
////            System.out.println("");
//                euclidMap.replace(i - 1, increment);
//            }
//
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            //euclidMap.replace(i, first)
//        }
//        //System.out.println(test+ "     this is the final value.....");
//    }

    public void extendedEuclidean1() {
        String substitute="";
        for (int i = euclidMap.size() - 1; i > 1; i--) {
            
            //String multEntry = euclidMap.get(i+1);
            //System.out.println("check " + multEntry);
            String getEntry = euclidMap.get(i);
            if (getEntry.charAt(0)=='-') {
                //System.out.println("Sub value   " + substitute);
             getEntry = getEntry.substring(getEntry.indexOf("=") + 1);
             String r1 = getEntry.substring(1);
            System.out.println(" IF   Entry to work on: " + r1);
                //System.out.println("Substu " + substitute);
                String s = substitute+"(";
            String multip = getEntry.substring(getEntry.indexOf(s)+3 , getEntry.length());
                //System.out.println("knibuu" + multip);
            multip = multip.replace("(", "");
            multip = multip.replace(")", "");
            
            getEntry = getEntry.replace("+", ",");
            //System.out.println("Multiplier: " + multip);
            String[] entry = getEntry.split(",");
            System.out.println("Substitute for: " + entry[1].substring(0, entry[1].indexOf("(")));
            //System.out.println("chlambuh");

            String nextEntry = euclidMap.get(i - 1);
            nextEntry = nextEntry.substring(nextEntry.indexOf("=") + 1);
            System.out.println("Next entry: " + nextEntry);
            
            String remove = entry[0].substring(1);
            System.out.println("IF   Next equation: " + remove + "-(" + nextEntry + ")" + multip);
            System.out.println();
            System.out.println("Distribute multiplier ");

            String secondEntry[] = nextEntry.split("-");
            int multOne = 0;
            int multTwo = 0;
            int multiplierToInt = Integer.parseInt(multip);
            String first, second;
            if (secondEntry[0].contains("(")) {
                multOne = Integer.parseInt(secondEntry[0].substring(secondEntry[0].indexOf("(") + 1, secondEntry[0].indexOf(")")));
                first = secondEntry[0].substring(0, secondEntry[0].indexOf("("));
            } else {
                first = secondEntry[0];
            }
            if (secondEntry[1].contains("(")) {
                multTwo = Integer.parseInt(secondEntry[1].substring(secondEntry[1].indexOf("(") + 1, secondEntry[1].indexOf(")")));
                second = secondEntry[1].substring(0, secondEntry[1].indexOf("("));
                substitute = second;
            } else {
                second = secondEntry[1];
                substitute = second;
            }
           // System.out.println(first + "    1st entry " + multOne);
            
           // System.out.println(second + "    2nd entry " + multTwo);

            if (multOne == 0) {
                multOne = multiplierToInt;
            } else {
                multOne = multOne * multiplierToInt;
            }
            if (multTwo == 0) {
                multTwo = multiplierToInt;
            } else {
                multTwo = multTwo * multiplierToInt;
            }       
            
            
                System.out.println(" IF  A B New equation");
                String reverse = entry[0] + "-" + first + "(" + multOne + ")" + "+" + second+ "(" + multTwo + ")";
                reverse = reverse.replace("\\+", "-");
                //reverse = reverse.replace("-", "+");
                //reverse = reverse.replaceFirst("\\+", "-");
                reverse = reverse.substring(1);
                
                System.out.println(reverse);
                
                int a = Integer.parseInt(entry[0].substring(entry[0].indexOf("(")+1, entry[0].indexOf(")")));
                System.out.println("Now collect like terms");
                //System.out.println( first + "(" + multOne + ")" + "-" + second+ "(" + (multTwo + a) + ")");
                //String newEntry = second + "(" + (multTwo + 1) + ")" +"-" + first + "(" + multOne + ")" ;
                String newEntry =  "-" + first + "(" + multOne + ")" + "+" + second+ "(" + (multTwo + a) + ")";
                
                //System.out.println(newEntry);
                euclidMap.replace(i - 1, newEntry);
                newEntry = newEntry.replace("\\+", "-");
               // newEntry = newEntry.replaceFirst("-", "+");
                //newEntry = newEntry.substring(1);
                //newEntry = newEntry.replaceFirst(".+\\.data", "-");
                System.out.println(newEntry );
                
            }else if (getEntry.contains("=")){
            getEntry = getEntry.substring(getEntry.indexOf("=") + 1);
            
            System.out.println(" Entry to work on: " + getEntry);
            String multiplier = getEntry.substring(getEntry.indexOf(substitute+"(") + 1, getEntry.length()-1);
                //System.out.println("help.................");
            System.out.println("Multiplier: " + multiplier);
            String[] entry = getEntry.split("-");
            System.out.println("Substitute for: " + entry[1].substring(0, entry[1].indexOf("(")));
            System.out.println();

            String nextEntry = euclidMap.get(i - 1);
            nextEntry = nextEntry.substring(nextEntry.indexOf("=") + 1);
            System.out.println("Next entry: " + nextEntry);

            System.out.println("Next equation: " + entry[0] + "-(" + nextEntry + ")" + multiplier);
            System.out.println();
            System.out.println("Distribute multiplier ");

            String secondEntry[] = nextEntry.split("-");
            int multOne = 0;
            int multTwo = 0;
            int multiplierToInt = Integer.parseInt(multiplier);
            String first, second;
            if (secondEntry[0].contains("(")) {
                multOne = Integer.parseInt(secondEntry[0].substring(secondEntry[0].indexOf("(") + 1, secondEntry[0].indexOf(")")));
                first = secondEntry[0].substring(0, secondEntry[0].indexOf("("));
            } else {
                first = secondEntry[0];
            }
            if (secondEntry[1].contains("(")) {
                multTwo = Integer.parseInt(secondEntry[1].substring(secondEntry[1].indexOf("(") + 1, secondEntry[1].indexOf(")")));
                second = secondEntry[1].substring(0, secondEntry[1].indexOf("("));
                substitute = second;
            } else {
                second = secondEntry[1];
                substitute = second;
            }
           // System.out.println(first + "    1st entry " + multOne);
            
           // System.out.println(second + "    2nd entry " + multTwo);

            if (multOne == 0) {
                multOne = multiplierToInt;
            } else {
                multOne = multOne * multiplierToInt;
            }
            if (multTwo == 0) {
                multTwo = multiplierToInt;
            } else {
                multTwo = multTwo * multiplierToInt;
            }       
            
            
                System.out.println("ELSE IF    New equation ");
                
                
                String reverse = entry[0] + "-" + first + "(" + multOne + ")" + "+" + second+ "(" + multTwo + ")";
//                reverse = reverse.replaceFirst("-", "+");
//                reverse = reverse.replace("+", "-");
                
                //reverse = reverse.substring(1);
                System.out.println(reverse);
                System.out.println();
                System.out.println("Now collect like terms haha");
                String newEntry = "-" + first + "(" + multOne + ")" + "+" + second+ "(" + (multTwo + 1) + ")";
                String r2 = newEntry.substring(1);
                System.out.println(r2);  
                euclidMap.replace(i - 1, newEntry);
                System.out.println();
                }
            
            else{
                getEntry = euclidMap.get(i);
            
                
                System.out.println("Sub value   " + substitute);
             //getEntry = getEntry.substring(getEntry.indexOf("=") + 1);
            System.out.println(" ELSE     Entry to work on: " + getEntry);
                //System.out.println("Substu " + substitute);
                String s = substitute+"(";
            String multiplier = getEntry.substring(getEntry.indexOf(s) + 1, getEntry.length());
            multiplier = multiplier.substring(multiplier.indexOf("(")+1, multiplier.indexOf(")"));
//            multiplier = multiplier.replace("(", "");
//            multiplier = multiplier.replace(")", "");
            
            getEntry = getEntry.replace("+", ",");
            System.out.println("Multiplier: " + multiplier);
            
            String[] entry = getEntry.split("-");
            
            System.out.println("Substitute for: " + entry[1].substring(0, entry[1].indexOf("(")));
            //System.out.println("chlambuh");

            String nextEntry = euclidMap.get(i - 1);
            nextEntry = nextEntry.substring(nextEntry.indexOf("=") + 1);
            System.out.println("Next entry: " + nextEntry);

            System.out.println(" ELSE     Next equation: " + substitute + "-(" + nextEntry + ")" + multiplier);
            System.out.println();
            System.out.println("Distribute multiplier ");

            String secondEntry[] = nextEntry.split("-");
            int multOne = 0;
            int multTwo = 0;
            int multiplierToInt = Integer.parseInt(multiplier);
            String first, second;
            if (secondEntry[0].contains("(")) {
                multOne = Integer.parseInt(secondEntry[0].substring(secondEntry[0].indexOf("(") + 1, secondEntry[0].indexOf(")")));
                first = secondEntry[0].substring(0, secondEntry[0].indexOf("("));
            } else {
                first = secondEntry[0];
            }
            if (secondEntry[1].contains("(")) {
                multTwo = Integer.parseInt(secondEntry[1].substring(secondEntry[1].indexOf("(") + 1, secondEntry[1].indexOf(")")));
                second = secondEntry[1].substring(0, secondEntry[1].indexOf("("));
                substitute = second;
            } else {
                second = secondEntry[1];
                substitute = second;
            }
            System.out.println(first + "    1st entry " + multOne);
            
            System.out.println(second + "    2nd entry " + multTwo);

            if (multOne == 0) {
                multOne = multiplierToInt;
            } else {
                multOne = multOne * multiplierToInt;
            }
            if (multTwo == 0) {
                multTwo = multiplierToInt;
            } else {
                multTwo = multTwo * multiplierToInt;
            }       
            
            
                System.out.println("ELSE    New equation");
                System.out.println(second + "-" + first + "(" + multOne + ")" + "+" + second+ "(" + multTwo + ")");
                System.out.println();
                System.out.println("Now collect like terms");
                //System.out.println("-" + first + "(" + multOne + ")" + "+" + second+ "(" + (multTwo + 1) + ")");
                String newEntry = second + "(" + (multTwo + 1) + ")" +"-" + first + "(" + multOne + ")" ;
                System.out.println(newEntry);
                euclidMap.replace(i - 1, newEntry);
                System.out.println();
            }
        
    }
}

}
