package controler;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controler implements ActionListener {
    private ArrayList<Airline> airlines;
    private Auth auth;
    private Home home;
    private CheckFlights checkFlights;
    private AuthValidation authValidation;
    private ArrayList<String> testCredentials = new ArrayList();
    
    public Controler() {}
    
    public Controler(ArrayList<Airline> airlines, Auth auth, Home home, CheckFlights checkFlights, AuthValidation authValidation) {
        this.airlines = airlines;
        this.auth = auth;        
        this.home = home;        
        this.checkFlights = checkFlights;
        this.authValidation = authValidation;
        
        // Adding one action listener to each needed element in the Auth window
        this.auth.login.addActionListener(this);
        this.auth.signUp.addActionListener(this);
        
        // Adding one action istener to each needed element in the Home Window
        this.home.checkFlights.addActionListener(this);
        this.home.bookFlight.addActionListener(this);
        this.home.buyTicket.addActionListener(this);
        this.home.logOut.addActionListener(this);
        
        //Adding one action listener to each element in the CheckFlights Window
        this.checkFlights.flightsSchedule.addActionListener(this);
        this.checkFlights.flightsRate.addActionListener(this);
        this.checkFlights.flightsInformation.addActionListener(this);
        
        // Initialazing the test credentials
        this.testCredentials.add("k.salazar@utp.edu.co");       
        this.testCredentials.add("HelloWorld");        
    }
    
    public void start() {
        auth.setTitle("JavaScheduleFlights");
        auth.setVisible(true);
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
        }
    }
    
    private void login(String email, String password) {
        // Validate if the email or password are empty 
        if(authValidation.areEmpty(email, password)) {
            auth.setVisible(false);
            
            home.setVisible(true);
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
            
            if(authValidation.isEmail(email) && authValidation.isPassword(password)) {
                // TODO: In this section we should add code that add a new user in the data base, however we are not doing it right now. 
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
