/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import view.Auth;

/**
 *
 * @author butch
 */
public class AuthValidation {
    public AuthValidation(){}
   
    public boolean isEmail(String email) {
        Pattern pattern = Pattern.compile("[a-zA-Z][\\w-]{1,20}@\\w{2,20}\\.\\w{2,3}");
        
        Matcher matcher = pattern.matcher(email);
        
        return matcher.find();
    }
    
    public boolean isPassword(String password) {
        Pattern pattern = Pattern.compile("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@%#$]).{8,20})");
        
        Matcher matcher = pattern.matcher(password);
        
        return matcher.find();
    }
    
    public boolean foundPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
    
    public static int getUserIndex(ArrayList<User> users, String email) {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getEmail().equals(email)) {
               return i; 
            }
        }
        
        
        
        return -1;
    }
    
    public static boolean isANumber(String number) {
        try {
            int value = Integer.parseInt(number);
            
            return true;
        } catch (NumberFormatException e) {
            System.out.println("This is not an integer.");
        }
        
        return false;
    }
    
    public static boolean isID(String ID) {
        try {
            long value = Long.parseLong(ID);
                    
            return true;
        } catch(NumberFormatException e) {
            System.out.println("This is not a long number");
        }
        
        return false;
    }
}
