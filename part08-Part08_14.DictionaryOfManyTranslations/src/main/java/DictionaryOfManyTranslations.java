
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class DictionaryOfManyTranslations {
    private final String word;
    private final String translation;
    private final HashMap<String, ArrayList<String>> dict;

    public DictionaryOfManyTranslations() {
        this.word = "";
        this.translation = "";
        this.dict = new HashMap<>();
    }
    
    public void add(String word, String translation){
        this.dict
                .computeIfAbsent(word, k -> new ArrayList<String>()).add(translation);
    }
    
    public ArrayList<String> translate(String word) {
        if (this.dict.containsKey(word)) {
            return this.dict.get(word);
        }
        
        return new ArrayList<>();
    }
    
    public void remove(String word) {
        this.dict.remove(word);
    }
}
