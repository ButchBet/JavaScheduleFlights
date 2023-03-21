package javascheduleflights;

import java.io.*;
import org.json.simple.*;

public class JSONWriter {
    public JSONWriter(){}
    
    public static void main(JSONObject object,String URL) {
      try {
         FileWriter file = new FileWriter(URL);
         
         file.write(object.toJSONString());
         
         file.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}
