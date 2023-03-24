package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javascheduleflights.JSONReader;
import org.json.simple.JSONObject;

public class DataBuilding {
    public DataBuilding(){}
    
    public static ArrayList<Airline> getAirlines(String path) {
        ArrayList<Airline> airlines = new ArrayList();
        ArrayList<JSONObject> arrayOfAirlines = new ArrayList();        
        
        JSONObject JSONAirlines = getJSONObject(path);
        
        // Saving each Airline information
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
            ArrayList<JSONObject> arrayOfAirplanes  = (ArrayList)arrayOfAirlines.get(i).get("airplanes");
            ArrayList<JSONObject> arrayOfFlights = (ArrayList)arrayOfAirlines.get(i).get("flights");            
            ArrayList<JSONObject> arrayOfTickets = (ArrayList)arrayOfAirlines.get(i).get("tickets");
            
            // Getting the airplanes
            airplanes = getAirplanes(arrayOfAirplanes);
            
            // Getting the flights
            flights = getFlights(arrayOfFlights);
            
            //Getting the tickets
            tickets = getTickets(arrayOfTickets);
            
            
            
            Airline airline = new Airline(airlineName, airplanes, flights, tickets);
            
            airlines.add(airline);
        }
        
        return airlines;        
    }
    
    public static ArrayList<User> getUsers(String path) {
        ArrayList<User> users = new ArrayList();
        ArrayList<JSONObject> arrayOfUsers = new ArrayList();
        
        JSONObject JSONUsers = getJSONObject(path);
        
        // Saving each user information 
        JSONUsers.keySet().forEach(key -> {
            arrayOfUsers.add((JSONObject)JSONUsers.get(key));
        });
        
        for(int i = 0; i < arrayOfUsers.size(); i++) {
            String firstName = (String)arrayOfUsers.get(i).get("firstName");
            String lastName = (String)arrayOfUsers.get(i).get("lastName");
            int age = Integer.parseInt(Long.toString((Long)arrayOfUsers.get(i).get("age")));
            long ID = (Long)arrayOfUsers.get(i).get("ID");
            
            User user = new User(firstName, lastName, age, ID);
            
            users.add(user);
        }
        
        return users;
    }
    
    private static JSONObject getJSONObject(String path) {
        String newPath = new File(path).getAbsolutePath();
        
        JSONObject object = JSONReader.main(newPath);
        
        return object;
    }
    
    private static ArrayList<Airplane> getAirplanes(ArrayList<JSONObject> data) {
        ArrayList<Airplane> airplanes = new ArrayList();
       
        for(int i = 0; i < data.size(); i++) {
            String name = (String)data.get(i).get("name");                
            boolean state = (boolean)data.get(i).get("state");                
            int capacity = Integer.parseInt(Long.toString((Long)data.get(i).get("capacity")));    
            String SN = (String)data.get(i).get("SN");
                
            Airplane airplane = new Airplane(name, state, capacity, SN);
                
            airplanes.add(airplane);
        }
        
        return airplanes;
   }
    
    private static ArrayList<Flight> getFlights(ArrayList<JSONObject> data) {
        ArrayList<Flight> flights = new ArrayList();
        
        for(int i = 0; i < data.size(); i++) {
            boolean state = (boolean)data.get(i).get("state");
            String from = (String)data.get(i).get("from");
            String to = (String)data.get(i).get("to");
            String airplaneSN = (String)data.get(i).get("airplaneSN");
            double costFistClass = Double.parseDouble(Double.toString((Long)data.get(i).get("costFirstClass")));
            double costSecondClass = costFistClass * 0.75;
            int day = Integer.parseInt(Long.toString((Long)data.get(i).get("day")));
            int month = Integer.parseInt(Long.toString((Long)data.get(i).get("month")));
            int year = Integer.parseInt(Long.toString((Long)data.get(i).get("year")));
            int capacity = Integer.parseInt(Long.toString((Long)data.get(i).get("capacity")));
                
            Date date = new Date(year, month - 1, day);  
                
            Flight flight = new Flight(state,  from, to, airplaneSN, costFistClass, costSecondClass, date, capacity);
               
            flights.add(flight);
        }
            
        return flights;    
    }
    
    private static ArrayList<Ticket> getTickets(ArrayList<JSONObject> data) {
        ArrayList<Ticket> tickets = new ArrayList();
        
        for(int i = 0; i < data.size(); i++) {
            String ID = (String)data.get(i).get("ID");
            double cost = Double.parseDouble(Double.toString((Long)data.get(i).get("cost")));
            boolean state = (boolean)data.get(i).get("state");
            String firstName = (String)data.get(i).get("firstName");
            String lastName = (String)data.get(i).get("lastName");
            String userID = (String)data.get(i).get("serID");
            boolean category = (boolean)data.get(i).get("category");
                
            Ticket ticket = new Ticket(ID, cost, state, firstName, lastName, userID, category);
                
            tickets.add(ticket);
        }
            
         return tickets;
    }
}
