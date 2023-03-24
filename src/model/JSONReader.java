package model;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class JSONReader {
    public JSONReader(){}
    
    public static JSONObject main(String path) {
        JSONParser parser = new JSONParser();
        
        try {
            Object obj = parser.parse(new FileReader(path));
         
            JSONObject jsonObject = (JSONObject)obj;
            
            return jsonObject;
        } catch(Exception e) {
             e.printStackTrace();
        }
        
        return null;
    } 
}
