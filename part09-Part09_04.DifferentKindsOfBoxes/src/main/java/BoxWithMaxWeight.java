
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
public class BoxWithMaxWeight extends Box {
    
    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (item.getWeight() <= this.capacity){
            this.capacity -= item.getWeight();
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        for (Item piece: this.items){
            if (piece.equals(item)){
                return true;
            }
        }
        return false;
    }
    
}
