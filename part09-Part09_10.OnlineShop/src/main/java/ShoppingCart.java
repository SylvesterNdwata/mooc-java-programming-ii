
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ndwat
 */
public class ShoppingCart {

    private Map<String, Item> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void add(String product, int price) {
        Item item = new Item(product, 1, price);

        for (Item piece : this.cart.values()) {
            if (piece.equals(item)) {
                piece.increaseQuantity();
                return;
            }
        }

        cart.put(product, item);
    }

    public int price() {
        int totalPrice = 0;

        for (Item piece : this.cart.values()) {
            totalPrice += piece.price();
        }

        return totalPrice;
    }
    
    public void print() {
        for (Item piece: this.cart.values()) {
            System.out.println(piece);
        }
    }
}
