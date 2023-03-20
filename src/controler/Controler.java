package controler;

import java.util.ArrayList;
import java.util.Scanner;
import model.Airline;
import model.Airplane;
import model.Ticket;
import model.Flight;

public class Controler {
    private ArrayList<Airline> airlines;
    private ArrayList<Airplane> airplanes;
    private ArrayList<Ticket> flight;
    private ArrayList<Flight> tickes;
    
    Controler() {}
    
    Controler(ArrayList<Airline> airlines) {
        this.airlines = airlines;
    }
    
    public static void start() {
        
    }
}
