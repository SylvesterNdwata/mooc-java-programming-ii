/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class List<T> {

    private T[] values;
    private int firstFreeIndex;

    public List() {
        this.values = (T[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(T value) {
        if (this.firstFreeIndex == this.values.length) {
            grow();
        }

        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    public boolean contains(T value) {
        return this.indexOfValue(value) >= 0;
    }

    public void remove(T value) {
        int indexOfValue = this.indexOfValue(value);
        if (indexOfValue < 0) {
            return;
        }
        this.moveToTheLeft(indexOfValue);
        this.firstFreeIndex--;
    }

    public T value(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is outside of bounds");
        }

        return this.values[index];
    }

    public int size() {
        return this.firstFreeIndex;
    }

    public int indexOfValue(T value) {
        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] == value) {
                return i;
            }
        }

        return -1;
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    private void grow() {
        int newSize = (this.values.length * 2) / 2;
        T[] newValues = (T[]) new Object[newSize];

        for (int i = 0; i < newValues.length; i++) {
            newValues[i] = this.values[i];
        }

        this.values = newValues;
    }
}
