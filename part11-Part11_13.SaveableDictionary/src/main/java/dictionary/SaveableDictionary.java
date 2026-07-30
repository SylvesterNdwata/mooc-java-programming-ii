/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ndwat
 */
public class SaveableDictionary {

    private HashMap<String, String> dictionary;
    private String file;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.file = file;
        this.dictionary = new HashMap<>();
    }

    public boolean load() {
        try {
            Files.lines(Paths.get(this.file))
                    .map(l -> l.split(":"))
                    .filter(parts -> parts.length >= 2)
                    .forEach(parts -> {
                        this.dictionary.putIfAbsent(parts[0], parts[1]);
                        this.dictionary.putIfAbsent(parts[1], parts[0]);
                    });

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(new File(this.file));
            ArrayList<String> alreadyInFile = new ArrayList<>();

            this.dictionary.keySet().stream()
                    .forEach(t -> {
                        if (alreadyInFile.contains(t)) {
                            return;
                        }

                        alreadyInFile.add(t);
                        alreadyInFile.add(this.dictionary.get(t));

                        writer.println(t + ":" + this.dictionary.get(t));
                    });
            
            writer.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void add(String words, String translation) {
        this.dictionary.putIfAbsent(words, translation);
        this.dictionary.putIfAbsent(translation, words);
    }

    public String translate(String word) {
        if (!this.dictionary.keySet().contains(word)) {
            return null;
        }

        return this.dictionary.get(word);
    }

    public void delete(String word) {
        this.dictionary.remove(this.dictionary.get(word));
        this.dictionary.remove(word);
    }
}
