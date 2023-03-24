package javascheduleflights;

import java.util.ArrayList;
import controler.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;
import model.*;
import org.json.simple.*;
import view.*;

public class JavaScheduleFlights {
    public static void main (String[] args) {
        ArrayList<Airline> airlines = new ArrayList();
        Auth auth = new Auth();
        Home home = new Home();
        CheckFlights checkFlights = new CheckFlights();
        FlightsContent flightsContent = new FlightsContent();
        AuthValidation authValidation = new AuthValidation();
                
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
            // ArraysLists to save the airplanes, flights and tickets because they are in JSONObject inside the Airlines ArrayList
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
        
        Controler controler = new Controler(airlines, auth, home, checkFlights, flightsContent, authValidation);
        
        // Startin the Graphic program
        controler.start();
    }
    
    
    // Method user to check that the Airlines were setted correctly
    public static void toString(ArrayList<Airline> airlines) {
        String finalText = "Airlines\n";
        
        if(!airlines.isEmpty()) {
            for(int i = 0; i < airlines.size(); i++) {
                finalText += (i + 1) + airlines.get(i).toString() + "\n\n\n" ;
            }
        }
        
        System.out.println(finalText);
    }
}