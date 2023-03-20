package javascheduleflights;

import java.util.ArrayList;
import model.Airline;
import controler.Controler;
import java.util.Scanner;
import model.Airplane;
import model.Ticket;
import model.Flight;

public class JavaScheduleFlights {
    private  ArrayList<Airline> airlines;
    private ArrayList<Airplane> airplanes;
    private ArrayList<Ticket> flight;
    private ArrayList<Flight> tickes;
    
    public JavaScheduleFlights() {
        airlines = new ArrayList<Airline>();  
    }
  
    public void addAirline(Airline airline) {    
        airlines.add(airline);  
    }
  
    public void removeAirline(Airline airline) {    
        airlines.remove(airline);  
    }
  
    public ArrayList<Airline> getAirlines() {    
        return airlines;  
    }
    
    public static void main (String[] args) {
        ArrayList<String> airlinesName = new ArrayList();
        
        airlinesName.add("DragonLine");
        airlinesName.add("NinjaLine");
        airlinesName.add("AviancaLine");
        
        System.out.println(args.toString());
        
        
        Scanner cmd = new Scanner(System.in);
        
        // Filling the Airlain array with the respective properties, in this case also the Airplanes, tickets and Flights
        for(int i = 0; i < 3; i++){ 
            
            
        }
    }
}