/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author matthewbelgre
 */
public class FileProcessor {
    private List<String> englishWords;
    private List<String> germanWords;
    private List<String> frenchWords;
    private List<String> spanishWords;
    private List<String> italianWords;
       
    public FileProcessor(){
        this.englishWords = new ArrayList<>();
        this.germanWords = new ArrayList<>();
        this.frenchWords = new ArrayList<>();
        this.spanishWords = new ArrayList<>();
        this.italianWords = new ArrayList<>();
        getData();
    }
    private void getData(){
        Scanner en=null;
        Scanner gr=null;
        Scanner fr=null;
        Scanner it=null;
        Scanner sp=null;
        boolean err0 =false;
        try {
            en = new Scanner(Paths.get( "englishLower.txt" ));
            gr = new Scanner(Paths.get( "germanLower.txt" )); 
            fr = new Scanner(Paths.get( "frenchLower.txt" )); 
            it = new Scanner(Paths.get( "italianLower.txt" )); 
            sp = new Scanner(Paths.get( "spanishLower.txt" )); 
            
        } catch (IOException ex) {
          err0 =true;             
        }
         if (!err0)  // if couldn't open file then skip
        {
           while(en.hasNext()){
            String word =en.nextLine();
             englishWords.add((String)word.toUpperCase());
            }
           
            while(gr.hasNext()){
            String word = gr.nextLine();
             germanWords.add((String)word.toUpperCase());
            }
             while(fr.hasNext()){
            String word =fr.nextLine();
             frenchWords.add((String)word.toUpperCase());
            }
              while(sp.hasNext()){
            String word =sp.nextLine();
             spanishWords.add((String)word.toUpperCase());
            }
               while(it.hasNext()){
            String word =it.nextLine();
             italianWords.add((String)word.toUpperCase());
            }
         
         
         }}


    public List<String> getEnglishWords(){
        return this.englishWords;
    }

    public List<String> getSpanishWords() {
        return spanishWords;
    }
    

    public List<String> getGermanWords() {
        return germanWords;
    }

    public List<String> getFrenchWords() {
        return frenchWords;
    }

    public List<String> getItalianWords() {
        return italianWords;
    }


}


