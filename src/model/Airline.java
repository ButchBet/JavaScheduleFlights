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
}
