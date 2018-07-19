
package cifrarjson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class archivoJSON 
{
    private     String ruta = "";
    private     FileReader archivo = null;
    private     JsonParser parser;
    private     FileReader fr;
    private     Map<String,Object> map;
    private     int tamanio;
    private     String [] llave;
    private     String [] valores;    
    private     String json ;
    
    
    
    public archivoJSON(String ruta, FileReader archivo)
    {
       this.ruta = ruta;
       this.archivo = archivo;
    }
    
    public void cargarJson() throws FileNotFoundException
    {
        Gson gson = new Gson();
        parser = new JsonParser();
        fr = new FileReader(ruta);
        JsonElement datos = parser.parse(fr);
        String json = datos.toString();
        System.out.println(json);
        
        map = new HashMap<String,Object>();
        map =  (Map<String,Object>) gson.fromJson(json, map.getClass());
    }
    
    public int obtenerTamanio()
    {
        int tamanio = 0;
        tamanio = map.size();
        return tamanio;
    }
    
    public String [] clave ()
    {
        llave = (String[]) map.values().toArray();
        return llave;
    }
    
    public String [] valores()
    {
        valores = (String[]) map.values().toArray();
        return valores;
    }
    
}
