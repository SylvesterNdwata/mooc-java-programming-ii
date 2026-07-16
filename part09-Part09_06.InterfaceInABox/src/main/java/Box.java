
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
public class Box implements Packable {

    private double capacity;
    private ArrayList<Packable> packables;

    public Box(double capacity) {
        this.capacity = capacity;
        this.packables = new ArrayList<>();
    }

    public void add(Packable packable) {
        if (this.capacity >= packable.weight()) {
            this.packables.add(packable);
            this.capacity -= packable.weight();
        }
    }

    public double weight() {
        double weight = 0;

        for (Packable item : this.packables) {
            weight += item.weight();
        }

        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + this.packables.size() + " items, " + "total weight " + this.weight() + " kg";
    }
}
