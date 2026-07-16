
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
public class MisplacingBox extends Box {
    
    private ArrayList<Item> inMisplacingBox;

    public MisplacingBox() {
        this.inMisplacingBox = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        this.inMisplacingBox.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
    
}
