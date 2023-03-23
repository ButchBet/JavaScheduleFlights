package model;

import java.util.ArrayList;

public class Airline {
    private String name;
    private ArrayList<Airplane> airplanes;    
    private ArrayList<Flight> flights;
    private ArrayList<Ticket> tickets;


    public Airline() {}
    
    public Airline(String name, ArrayList<Airplane> airplanes, ArrayList<Flight> flights, ArrayList<Ticket> tickets) {
        this.name = name;        
        this.airplanes = airplanes;
        this.flights = flights;
        this.tickets = tickets;
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(ArrayList<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    public String toString() {
        int i;
        String finalText = "Name: " + name + "\n\nAirplanes";
        
        // Loop to get the string to the Airplanes
        if(!airplanes.isEmpty()) { // Avoid a size 0 error
            for(i = 0; i < airplanes.size(); i++) {
                finalText +=  "\n" + (i + 1) + ": " + airplanes.get(i).toString();
            }
        }
        
        finalText += "\n\nFlights";
        
        //Loop to get the string to the Flights
        if(!flights.isEmpty()) {
            for(i = 0; i < flights.size(); i++) {
                finalText += "\n" + (i + 1) + ": " + flights.get(i).toString(); 
            }
        }
        
        finalText += "\n\nTickets";
        // Loop to get the string to the Tickets
        if(!tickets.isEmpty()) {
            for(i = 0; i < tickets.size(); i++) {
                finalText += "\n" + (i + 1) + ": " + tickets.get(i).toString();
            }
        }
        
        return finalText;
    }
}
