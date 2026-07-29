/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author ndwat
 */
public class Flight {

    private Airplane plane;
    private Place departure;
    private Place destination;

    public Flight(Airplane plane, Place departure, Place destination) {
        this.plane = plane;
        this.departure = departure;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return this.plane.toString() + " (" + this.departure + "-" + this.destination + ")";
    }
}
