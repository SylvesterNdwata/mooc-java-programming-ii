
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
public class Abbreviations {

    HashMap<String, String> abbreviations;

    public Abbreviations() {
        this.abbreviations = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        abbreviation = sanitizeString(abbreviation);

        if (hasAbbreviation(abbreviation) == false) {
            this.abbreviations.put(abbreviation, explanation);
        }
    }

    public boolean hasAbbreviation(String abbreviation) {
        abbreviation = sanitizeString(abbreviation);

        return this.abbreviations.containsKey(abbreviation);
    }

    public String findExplanationFor(String abbreviation) {
        abbreviation = sanitizeString(abbreviation);

        if (this.abbreviations.containsKey(abbreviation)) {
            return this.abbreviations.get(abbreviation);
        }

        return null;

    }

    public static String sanitizeString(String string) {
        if (string == null) {
            string = "";
        }

        string = string.toLowerCase();
        return string.trim();
    }

}
