package controler;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener {
    private ArrayList<Airline> airlines;
    private Auth auth;
    private Home home;
    private CheckFlights checkFlights;
    
    public Controler() {}
    
    public Controler(ArrayList<Airline> airlines, Auth auth, Home home, CheckFlights checkFlights) {
        this.airlines = airlines;
        this.auth = auth;        
        this.home = home;        
        this.checkFlights = checkFlights;
        
        // Adding one action listener to each needed element in the Auth window
        this.auth.email.addActionListener(this);
        this.auth.password.addActionListener(this);
        
        // Adding one action istener to each needed element in the Home Window
        this.home.checkFlights.addActionListener(this);
        this.home.bookFlight.addActionListener(this);
        this.home.buyTicket.addActionListener(this);
        this.home.logOut.addActionListener(this);
        
        //Adding one action listener to each element in the CheckFlights Window
        this.checkFlights.flightsSchedule.addActionListener(this);
        this.checkFlights.flightsRate.addActionListener(this);
        this.checkFlights.flightsInformation.addActionListener(this);
    }
    
    public static void start() {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
