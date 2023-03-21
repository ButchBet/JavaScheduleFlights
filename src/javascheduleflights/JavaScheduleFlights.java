package javascheduleflights;

import java.util.ArrayList;
import model.Airline;
import controler.Controler;
import java.io.*;
import java.util.Date;
import java.util.Scanner;
import model.Airplane;
import model.Ticket;
import model.Flight;
import org.json.simple.*;

public class JavaScheduleFlights {
    public static void main (String[] args) {
        ArrayList<Airline> airlines = new ArrayList();
        ArrayList<JSONObject> arrayOfAirlines = new ArrayList();        
        ArrayList<JSONObject> arrayOfAirplanes = new ArrayList();        
        ArrayList<JSONObject> arrayOfFlights = new ArrayList();        
        ArrayList<JSONObject> arrayOfTickets = new ArrayList();
        
        String path = new File("src/model/airlines.json").getAbsolutePath();
        
        JSONObject JSONAirlines = JSONReader.main(path);
        
        JSONAirlines.keySet().forEach(key -> {
            arrayOfAirlines.add((JSONObject)JSONAirlines.get(key));
        });
        
        // Filling the Airlanes ArrayList with the respective properties, in this case also the Airplanes, tickets and Flights ArrayLists
        for(int i = 0; i < arrayOfAirlines.size(); i++){ 
            ArrayList<Airplane> airplanes = new ArrayList();
            ArrayList<Flight> flights = new ArrayList();
            ArrayList<Ticket> tickets = new ArrayList();
            
            String airlineName = (String)arrayOfAirlines.get(i).get("name");
            arrayOfAirplanes  = (ArrayList)arrayOfAirlines.get(i).get("airplanes");
            arrayOfFlights = (ArrayList)arrayOfAirlines.get(i).get("flights");            
            arrayOfTickets = (ArrayList)arrayOfAirlines.get(i).get("tickets");
            
            // Loop to save j airplanes of i airline in airplanes
            for(int j = 0; j < arrayOfAirplanes.size(); j++) {
                String name = (String)arrayOfAirplanes.get(j).get("name");                
                boolean state = (boolean)arrayOfAirplanes.get(j).get("state");                
                int capacity = Integer.parseInt(Long.toString((Long)arrayOfAirplanes.get(j).get("capacity")));    
                String SN = (String)arrayOfAirplanes.get(j).get("SN");
                
                Airplane airplane = new Airplane(name, state, capacity, SN);
                
                airplanes.add(airplane);
            }
            
            // Loop to save j flights of i airline in flights
            for(int j = 0; j < arrayOfFlights.size(); j++) {
                boolean state = (boolean)arrayOfFlights.get(j).get("state");
                String from = (String)arrayOfFlights.get(j).get("from");
                String to = (String)arrayOfFlights.get(j).get("to");
                String airplaneSN = (String)arrayOfFlights.get(j).get("airplaneSN");
                double costFistClass = Double.parseDouble(Double.toString((Long)arrayOfFlights.get(j).get("costFirstClass")));
                double costSecondClass = costFistClass * 0.75;
                int day = Integer.parseInt(Long.toString((Long)arrayOfFlights.get(j).get("day")));
                int month = Integer.parseInt(Long.toString((Long)arrayOfFlights.get(j).get("month")));
                int year = Integer.parseInt(Long.toString((Long)arrayOfFlights.get(j).get("year")));
                int capacity = Integer.parseInt(Long.toString((Long)arrayOfFlights.get(j).get("capacity")));
                
                Date date = new Date(year, month - 1, day);  
                
                Flight flight = new Flight(state,  from, to, airplaneSN, costFistClass, costSecondClass, date, capacity);
               
                flights.add(flight);
            }
            
            // Loof to save j tickets of i ariline in tickets 
            for(int j = 0; j < arrayOfTickets.size(); j++) {
                String ID = (String)arrayOfTickets.get(j).get("ID");
                double cost = Double.parseDouble(Double.toString((Long)arrayOfTickets.get(j).get("cost")));
                boolean state = (boolean)arrayOfTickets.get(j).get("state");
                String firstName = (String)arrayOfTickets.get(j).get("firstName");
                String lastName = (String)arrayOfTickets.get(i).get("lastName");
                String userID = (String)arrayOfTickets.get(j).get("serID");
                boolean category = (boolean)arrayOfTickets.get(j).get("category");
                
                Ticket ticket = new Ticket(ID, cost, state, firstName, lastName, userID, category);
                
                tickets.add(ticket);
            }
            
            Airline airline = new Airline(airlineName, airplanes, flights, tickets);
            
            airlines.add(airline);
        }
        
        System.out.println(airlines);
    }
}