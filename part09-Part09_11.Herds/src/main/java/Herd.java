
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class Herd implements Movable {
    
    private ArrayList<Movable> movables;

    public Herd() {
        this.movables = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        this.movables.add(movable);
    }

    public void move(int dx, int dy) {
        for (Movable stuck: this.movables) {
            stuck.move(dx, dy);
        }
    }
    
    @Override
    public String toString() {
        String finalString = "";
        for (Movable stuck: this.movables) {
            finalString += stuck.toString() + "\n";
        }
        return finalString;
    }
}
