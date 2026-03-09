/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class Container {
    private int content;

    public Container() {
        this.content = 0;
    }
    
    public int contains() {
        return this.content;
    }
    
    public void add(int amount) {
        if (this.content + amount > 100) {
            this.content = 100;
        }
        if (amount > 0 && this.content + amount <= 100) {
            this.content += amount;
        }
    }
    
    public void remove(int amount) {
        if (amount > 0 && this.content - amount <= 0) {
            this.content = 0;
        }
        
        if (amount > 0 && this.content > amount) {
            this.content -= amount;
        }
    }
    
    public String toString() {
        return this.content + "/100";
    }
}
