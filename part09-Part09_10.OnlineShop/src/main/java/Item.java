
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class Item {
    
    private String product;
    private int qty;
    private int unitPrice;

    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    
    public int price() {
        return this.qty * this.unitPrice;
    }
    
    public void increaseQuantity() {
        this.qty++;
    }
    
    @Override
    public String toString() {
        return this.product + ": " + this.qty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.product);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Item)) return false;
        Item item = (Item) obj;
        return Objects.equals(this.product, item.product);
    }
    
    
}
