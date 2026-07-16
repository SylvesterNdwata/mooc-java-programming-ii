
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
public class OneItemBox extends Box {
    
    private ArrayList<Item> itemInBox;
    private int weight;

    public OneItemBox() {
        this.weight = 1;
        this.itemInBox = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (this.itemInBox.isEmpty())
            this.itemInBox.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        for (Item piece: this.itemInBox){
            if (piece.equals(item)){
                return true;
            }
        }
        return false;
    }
    
}
