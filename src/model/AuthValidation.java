/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import view.Auth;

/**
 *
 * @author butch
 */
public class AuthValidation {
    public AuthValidation(){}
       
    public static boolean areEmpty(String email, String password) {
        if(email.isEmpty() || password.isEmpty()) {
            return true;
        }
        
        return false;
    }
    
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
}