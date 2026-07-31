
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
public class Hideout<T> {
    
    private T element;

    public Hideout() {
    }
    
    public void putIntoHideout(T toHide) {
        this.element = toHide;
    }
    
    public T takeFromHideout() {
        T value = this.element;
        this.element = null;
        
        return value;
    }
    
    public boolean isInHideout() {
        if (this.element == null)
            return false;
        
        return true;
    }
}
