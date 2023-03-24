package controler;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SwingConstants;

public class Controler implements ActionListener {
    private ArrayList<Airline> airlines;
    private ArrayList<User> users;
    private Auth auth;
    private Home home;
    private CheckFlights checkFlights;
    private FlightsContent flightsContent;
    private AuthValidation authValidation = new AuthValidation();
    private ArrayList<String> testCredentials = new ArrayList();
    
    public Controler() {}
    
    public Controler(ArrayList<Airline> airlines, ArrayList<User> users, Auth auth, Home home, CheckFlights checkFlights, FlightsContent flightsContent) {
        this.airlines = airlines;
        this.users = users;
        this.auth = auth;        
        this.home = home;        
        this.checkFlights = checkFlights;
        this.flightsContent = flightsContent;
        
        // Adding one action listener to each needed element in the Auth window
        this.auth.login.addActionListener(this);
        this.auth.signUp.addActionListener(this);
        
        // Adding one action istener to each needed element in the Home Window
        this.home.checkFlights.addActionListener(this);
        this.home.bookFlight.addActionListener(this);
        this.home.logOut.addActionListener(this);
        
        //Adding one action listener to each element in the CheckFlights Window
        this.checkFlights.flightsDate.addActionListener(this);
        this.checkFlights.flightsCost.addActionListener(this);
        this.checkFlights.flightsInformation.addActionListener(this);
        this.checkFlights.backToHome.addActionListener(this);
    
        
        // Initialazing the test credentials
        this.testCredentials.add("k.salazar@utp.edu.co");       
        this.testCredentials.add("HelloWorld1023@");        
    }
    
    public void start() {
        auth.setTitle("Log In & Sing Up");
        home.setTitle("Home");
        checkFlights.setTitle("Check Flights");
        checkFlights.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Log in":
                login(auth.email.getText(), auth.password.getText());
                break;
            case "Sign up":
                signUp(auth.email.getText(), auth.password.getText());
                break;
            case "Check flights":
                home.setVisible(false);
                checkFlights.setVisible(true);
                break;
            case "Book flights":
                System.out.println("We are Booking flights.");
                break;
            case "Log out":
                // TODO: In this session we shoud ad the code that call any method that create the JSON file with the current Arilines data and then use the JSONWriter class to write the airlines.json file.
                home.setVisible(false);
                auth.setVisible(true);
                break;
            case "Flights date":
                System.out.println("We are checking Flights by date.");
                break;
            case "Flights cost":
                System.out.println("We are checing Flights by cost.");
                break;
            case "Flights information":
                System.out.println("We are checking Flights by information.");
                break;
            case "Back to home":
                checkFlights.setVisible(false);
                home.setVisible(true);
                break;
                
        }
    }
    
    private void login(String email, String password) {
        // Validate if the email or password are empty 
        if(!authValidation.areEmpty(email, password)) {
            // TODO: In this session we should add the code that search in the data base, however we are not doing it right now. 
            // We are planing to use a JSON file in order to read and write users becase we don't have knowledge in Data Bases and servers hehe
            if(authValidation.foundEmail(testCredentials.get(0), email) && authValidation.foundPassword(testCredentials.get(1), password)) {
                auth.setVisible(false);
                home.setVisible(true);
            } else {
                auth.message.setText("Invalid email or password");
            }
            
        } else {
            auth.message.setText("Email or password empty");
        }      
    }
    
    private void signUp(String email, String password) {
        // Validate if the email and password are empty 
        if(!authValidation.areEmpty(email, password)) {
            // checking if the email and password have the correct structure
            System.out.println(authValidation.isEmail(email));
            System.out.println(authValidation.isPassword(password));
            
            if(authValidation.isEmail(email) && authValidation.isPassword(password) && !authValidation.foundEmail(testCredentials.get(0), email)) {
                // TODO: In this session we should add code that add a new user in the data base, however we are not doing it right now. 
                // We are planing to use a JSON file in order to read and write users becase we don't have knowledge in Data Bases and servers hehe
                
                auth.setVisible(false);
                home.setVisible(true);
            } else {
               auth.message.setText("Invalid email or password");
            }
        } else {
            auth.message.setText("Email or password empty");
        } 
        
    }
}
