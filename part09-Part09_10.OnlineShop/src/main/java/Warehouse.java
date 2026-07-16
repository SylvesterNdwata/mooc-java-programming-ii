
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ndwat
 */
public class Warehouse {

    private Map<String, Integer> productPrice;
    private Map<String, Integer> productQuantity;

    public Warehouse() {
        this.productPrice = new HashMap<>();
        this.productQuantity = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.productPrice.put(product, price);
        this.productQuantity.put(product, stock);
    }

    public int price(String product) {
        if (this.productPrice.containsKey(product)) {
            return this.productPrice.get(product);
        }

        return -99;
    }

    public int stock(String product) {
        if (this.productQuantity.containsKey(product)) {
            return this.productQuantity.get(product);
        }

        return 0;
    }

    public boolean take(String product) {
        if (this.productQuantity.containsKey(product)) {
            int quantity = this.productQuantity.get(product);
            if (quantity > 0) {
                quantity -= 1;
                this.productQuantity.put(product, quantity);
                return true;
            }
        }

        return false;
    }
    
    public Set<String> products() {
        return this.productPrice.keySet();
    }
}
