/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author ndwat
 */
public class FlightControl {
    
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;
    private HashMap<String, Place> places;

    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }
    
    public void addAirplane(String ID, int capacity) {
       this.airplanes.put(ID, new Airplane(ID, capacity));
    }
    
    public void addFlight(Airplane airplane, String departureID, String destinationID) {
        this.places.putIfAbsent(departureID, new Place(departureID));
        this.places.putIfAbsent(destinationID, new Place(destinationID));
        
        Flight newFlight = new Flight(airplane, this.places.get(departureID), this.places.get(destinationID));
        
        this.flights.put(newFlight.toString(), newFlight);
    }

    public Collection<Airplane> getAirplanes() {
        return airplanes.values();
    }

    public Collection<Flight> getFlights() {
        return flights.values();
    }
    
    public Airplane getAirplane(String ID) {
        return this.airplanes.get(ID);
    }
}
