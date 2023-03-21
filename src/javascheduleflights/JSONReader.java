package javascheduleflights;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class JSONReader {
    public static JSONObject main(String URL) {
        JSONParser parser = new JSONParser();
        
        try {
            Object obj = parser.parse(new FileReader(URL));
         
            JSONObject jsonObject = (JSONObject)obj;
            
            return jsonObject;
        } catch(Exception e) {
             e.printStackTrace();
        }
        
        return null;
    } 
}
