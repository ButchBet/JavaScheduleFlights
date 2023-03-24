package javascheduleflights;

import java.io.*;
import org.json.simple.*;

public class JSONWriter {
    public JSONWriter(){}
    
    public static void main(JSONObject object,String path) {
      try {
         FileWriter file = new FileWriter(path);
         
         file.write(object.toJSONString());
         
         file.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}
