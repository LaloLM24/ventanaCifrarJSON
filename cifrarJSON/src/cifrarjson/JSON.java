
package cifrarjson;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class JSON 
{

    public static void main(String[] args) throws IOException 
    {
        String ruta = "C:\\Users\\lalo\\Documents\\datos.json";
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        FileReader fr = new FileReader(ruta);
        JsonElement datos = parser.parse(fr);
        String json = datos.toString();
        System.out.println(json);
      
        Map<String,Object> map = new HashMap<String,Object>();
        map =  (Map<String,Object>) gson.fromJson(json, map.getClass());
        System.out.println(map.size());
        int tam = map.size();
            map.keySet();
            map.values();
       
            String[] keys = new String[map.size()];
            Object[] values = new Object[map.size()];
            int index = 0;
            for (Map.Entry<String, Object> mapEntry : map.entrySet()) 
            {
                keys[index] = mapEntry.getKey();
                values[index] = mapEntry.getValue();
                 System.out.println(keys[index] + " " + values[index]);
                index++;
                
               
            }
    }
    
}
