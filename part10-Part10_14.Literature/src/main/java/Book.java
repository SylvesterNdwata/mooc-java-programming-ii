/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class Book implements Comparable<Book> {
    
    private String name;
    private int ageRecommendation;

    public Book(String name, int ageRecommendation) {
        this.name = name;
        this.ageRecommendation = ageRecommendation;
    }

    public String getName() {
        return name;
    }

    public int getAgeRecommendation() {
        return ageRecommendation;
    }
    
    @Override
    public String toString() {
        return this.getName() + " (recommended for " + this.getAgeRecommendation() + " year-olds or older)";
    }

    @Override
    public int compareTo(Book book) {
        if (this.getAgeRecommendation() == book.getAgeRecommendation())
            return 0;
        else if (this.getAgeRecommendation() > book.getAgeRecommendation())
            return 1;
        else 
            return -1;
    }
}
