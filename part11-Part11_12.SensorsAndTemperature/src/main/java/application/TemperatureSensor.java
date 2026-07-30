/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author ndwat
 */
public class TemperatureSensor implements Sensor {

    private int number;

    public TemperatureSensor() {
        this.number = 0;
    }

    @Override
    public boolean isOn() {
        if (this.number == 0) {
            return false;
        }

        return true;
    }

    @Override
    public void setOn() {
        this.number = 1;
    }

    @Override
    public void setOff() {
        this.number = 0;
    }

    @Override
    public int read() {
        Random random = new Random();
        if (!this.isOn()) {
            throw new IllegalStateException();
        }

        return random.nextInt(61) - 30;

    }

}
