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
import org.json.simple.JSONObject;

public class Controler implements ActionListener {
    private ArrayList<Airline> airlines;
    private User user;
    private Auth auth;
    private CreateAccount createAccount;
    private Home home;
    private CheckFlights checkFlights;
    private FlightsContent flightsContent;
    private AuthValidation authValidation = new AuthValidation();
    private ArrayList<String> testCredentials = new ArrayList();
    
    public Controler() {}
    
    public Controler(ArrayList<Airline> airlines, Auth auth, CreateAccount createAccount, Home home, CheckFlights checkFlights, FlightsContent flightsContent) {
        this.airlines = airlines;
        this.auth = auth;  
        this.createAccount = createAccount;
        this.home = home;        
        this.checkFlights = checkFlights;
        this.flightsContent = flightsContent;
        
        // Adding one action listener to each needed element in the Auth window
        this.auth.login.addActionListener(this);
        this.auth.signUp.addActionListener(this);
        
        // Adding one acction listener to each needed element in the CreateAccount window
        this.createAccount.createAccount.addActionListener(this);
        this.createAccount.backToLogin.addActionListener(this);
        
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
        createAccount.setTitle("Create account");
        auth.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Log in":
                login(auth.email.getText(), auth.password.getText());
                break;
            case "Sign up":
                auth.setVisible(false);
                createAccount.setVisible(true);
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
            case "Create Account":
                signUp(createAccount.firstName.getText(), createAccount.lastName.getText(), createAccount.age.getText(), createAccount.email.getText(), createAccount.id.getText(), createAccount.password.getText(), createAccount.confirmPassword.getText());
                break;
            case "Back to login":
                createAccount.setVisible(false);
                auth.setVisible(true);
        }
    }
    
    private void login(String email, String password) {
        DataBuilding dataBuilding = new DataBuilding();
        ArrayList<User> users  = dataBuilding.getUsers("src/model/users.json");
        
        // Validate if the email or password are empty 
        if(!email.isEmpty() && !password.isEmpty()) {
            int userIndex = authValidation.getUserIndex(users, email);
    
            // If the email exist in and the password match
            if(userIndex != -1 && authValidation.foundPassword(users.get(userIndex), password)) {
                auth.setVisible(false);
                home.setVisible(true);
            } else {
                auth.realMessage.setText("Invalid email or password");
            }
            
        } else {
            auth.realMessage.setText("Email or password empty");
        }      
    }
    
    private void signUp(String firstName, String lastName, String age, String email, String ID, String password, String confirmPassword) {         
        DataBuilding dataBuilding = new DataBuilding();
        ArrayList<User> users  = dataBuilding.getUsers("src/model/users.json");
        
        // Validate if the email and password are empty 
        if(!firstName.isEmpty() && !lastName.isEmpty() && !age.isEmpty() && !email.isEmpty() && !ID.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()) {
            // Validate if the the email, ID, password and age structure are correct and then if the email does not exis
            if(authValidation.isEmail(email) && authValidation.isPassword(password) &&  authValidation.isID(ID) && authValidation.getUserIndex(users, email) == -1 && authValidation.isANumber(age)) {
                User newUser = new User(firstName, lastName, email, password, Integer.parseInt(age), Long.parseLong(ID));
                
                createAccount.firstName.setText("");
                createAccount.lastName.setText("");
                createAccount.email.setText("");
                createAccount.age.setText("");
                createAccount.id.setText("");
                createAccount.password.setText("");
                createAccount.confirmPassword.setText("");
                
                users.add(newUser);
                
                this.user = newUser;
                
                // TODO: Build the JsonObject of the user and write it in the user.json file
                
                createAccount.setVisible(false);
                home.setVisible(true);
            } else {
               auth.message.setText("Invalid data");
            }
        } else {
            createAccount.message.setText("Any blank space is empty");
        }
    }
}
