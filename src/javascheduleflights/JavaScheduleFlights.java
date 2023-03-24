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
        DataBuilding dataBuilding = new DataBuilding();
        
        //ArrayList<Airline> airlines = dataBuilding.getAirlines("src/model/airlines.json");
        ArrayList<User> users  = dataBuilding.getUsers("src/model/users.json");
        
        Auth auth = new Auth();
        Home home = new Home();
        CheckFlights checkFlights = new CheckFlights();
        FlightsContent flightsContent = new FlightsContent();
        
        //Controler controler = new Controler(airlines, users, auth, home, checkFlights, flightsContent);
        
        // Startin the Graphic program
        //controler.start();
        
        System.out.println(users);
        //System.out.println(airlines);
    }
    
    
    // Method user to check that the Airlines were setted correctly
    public static void toStringAirline(ArrayList<Airline> airlines) {
        String finalText = "Airlines\n";
        
        if(!airlines.isEmpty()) {
            for(int i = 0; i < airlines.size(); i++) {
                finalText += (i + 1) + airlines.get(i).toString() + "\n\n\n" ;
            }
        }
        
        System.out.println(finalText);
    }
    
    public static void toStringUsers(ArrayList<User> users) {
        
    }
    
    
}