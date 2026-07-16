/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class Book implements Packable {

    private String author;
    private String bookName;
    private double weight;

    public Book(String author, String bookName, double weight) {
        this.author = author;
        this.bookName = bookName;
        this.weight = weight;
    }

    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.author + ": " + this.bookName;
    }
}
