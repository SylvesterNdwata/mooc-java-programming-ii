/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class LiteracyRate implements Comparable<LiteracyRate> {
    
    private String theme;
    private String ageGroup;
    private String gender;
    private String country;
    private int year;
    private double literacyPercent;

    public LiteracyRate(String theme, String ageGroup, String gender, String country, int year, double literacyPercent) {
        this.theme = theme;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public String getCountry() {
        return country;
    }

    public String getGender() {
        return gender;
    }

    public double getLiteracyPercent() {
        return literacyPercent;
    }

    public String getTheme() {
        return theme;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(LiteracyRate compared) {
        if (this.getLiteracyPercent() == compared.getLiteracyPercent())
            return 0;
        else if (this.getLiteracyPercent() > compared.getLiteracyPercent())
            return 1;
        else 
            return -1;
    }
    
    @Override
    public String toString() {
        return this.getCountry() + " (" + this.getYear() + "), " + this.gender + ", " + this.getLiteracyPercent();
    }
}
