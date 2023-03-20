package model;

import java.util.ArrayList;

public class Airline {
    private String name;
    private ArrayList<Airplane> airplanes;    
    private ArrayList<Ticket> flights;
    private ArrayList<Flight> tickets;


    Airline() {}
    
    Airline(String name, ArrayList<Airplane> airplanes, ArrayList<Ticket> flights, ArrayList<Flight> tickets) {
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

    public ArrayList<Ticket> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Ticket> flights) {
        this.flights = flights;
    }

    public ArrayList<Flight> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Flight> tickets) {
        this.tickets = tickets;
    }
}
