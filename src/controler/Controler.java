package controler;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import view.*;

public class Controler {
    private ArrayList<Airline> airlines;
    
    public Controler() {}
    
    public Controler(ArrayList<Airline> airlines, Auth auth, Home home, CheckFlights checkFlights) {
        this.airlines = airlines;
    }
    
public static void start() {
        
    }
}
