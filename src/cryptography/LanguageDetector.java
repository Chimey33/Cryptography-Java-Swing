/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.util.List;

/**
 *
 * @author matthewbelgre
 */
public class LanguageDetector {
    private FileProcessor fp;
    private final List<String> englishWords;
    private final List<String> germanWords;
    private final List<String> frenchWords;
    private final List<String> spanishWords;
    private final List<String> italianWords;
    
    public LanguageDetector(){
        this.fp = new FileProcessor();
        this.englishWords = fp.getEnglishWords();
        this.frenchWords = fp.getFrenchWords();
        this.germanWords = fp.getGermanWords();
        this.italianWords = fp.getItalianWords();
        this.spanishWords = fp.getSpanishWords();
        
    }
    
    public int countEnglishWordsInText(String text){
        text = text.toLowerCase();
        
        String[] words = text.split(" ");
        
        int matches = 0;
        
        for(String word: words){
            if(englishWords.contains(word)){
                matches ++;
            }
        }
        return matches;
    }
    
    public boolean isTextEnglish(String text){
        int matches = countEnglishWordsInText(text);
        if(((float)matches / text.split(" ").length * 100) >=60){
        return true;
        }else 
        return false;
    }
    
     public int countGermanWordsInText(String text){
        text = text.toLowerCase();
        
        String[] words = text.split(" ");
        
        int matches = 0;
        
        for(String word: words){
            if(germanWords.contains(word)){
                matches ++;
            }
        }
        return matches;
    }
    
    public boolean isTextGerman(String text){
        int matches = countGermanWordsInText(text);
        if(((float)matches / text.split(" ").length * 100) >=70){
        return true;
        }else 
        return false;
    }
    
     public int countFrenchWordsInText(String text){
        text = text.toLowerCase();
        
        String[] words = text.split(" ");
        
        int matches = 0;
        
        for(String word: words){
            if(frenchWords.contains(word)){
                matches ++;
            }
        }
        return matches;
    }
    
    public boolean isTextFrench(String text){
        int matches = countFrenchWordsInText(text);
        if(((float)matches / text.split(" ").length * 100) >=70){
        return true;
        }else 
        return false;
    }
    
     public int countSpanishWordsInText(String text){
        text = text.toLowerCase();
        
        String[] words = text.split(" ");
        
        int matches = 0;
        
        for(String word: words){
            if(spanishWords.contains(word)){
                matches ++;
            }
        }
        return matches;
    }
    
    public boolean isTextSpanish(String text){
        int matches = countSpanishWordsInText(text);
        if(((float)matches / text.split(" ").length * 100) >=70){
        return true;
        }else 
        return false;
    }
    
     public int countItalianWordsInText(String text){
        text = text.toLowerCase();
        
        String[] words = text.split(" ");
        
        int matches = 0;
        
        for(String word: words){
            if(italianWords.contains(word)){
                matches ++;
            }
        }
        return matches;
    }
    
    public boolean isTextItalian(String text){
        int matches = countItalianWordsInText(text);
        if(((float)matches / text.split(" ").length * 100) >=70){
        return true;
        }else 
        return false;
    }
    
    public String checkLanguage(String text){
        String language ="";
        if(this.isTextEnglish(text)){
            language = "The text is in English";
            
        }else if(this.isTextItalian(text)){
            language = "The text is in Italian";
        }else if (this.isTextFrench(text)){
            language = "The text is in French";
        }else if(this.isTextGerman(text)){
            language = "The text is in German";
        }else if(this.isTextSpanish(text)){
            language = "The text is in Spanish";
        }
        else language = "This text is not English, German, French, Spanish or Italian";
         return language;
        
    }

    public List<String> getEnglishWords() {
        return englishWords;
    }

    public List<String> getGermanWords() {
        return germanWords;
    }

    public List<String> getFrenchWords() {
        return frenchWords;
    }

    public List<String> getSpanishWords() {
        return spanishWords;
    }

    public List<String> getItalianWords() {
        return italianWords;
    }
    
    
}
