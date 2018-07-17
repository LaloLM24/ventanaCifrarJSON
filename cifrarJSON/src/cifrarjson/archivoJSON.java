
package cifrarjson;

import java.io.FileReader;

public class archivoJSON 
{
    private     String ruta = "";
    private     FileReader archivo = null;
    
    public archivoJSON(String ruta, FileReader archivo)
    
    {
       this.ruta = ruta;
       this.archivo = archivo;
    }
    
    
    
}
