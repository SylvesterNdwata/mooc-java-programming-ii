
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class Hand implements Comparable<Hand> {
    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        this.cards.stream().forEach(c -> System.out.println(c));
    }
    
    public void sort() {
        Collections.sort(this.cards);
    }
    
    private int totalValue() {
        return cards.stream().mapToInt(Card::getValue).sum();
    }

    @Override
    public int compareTo(Hand hand) {
        return Integer.compare(this.totalValue(), hand.totalValue());
    }
    
    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());
    }
}
