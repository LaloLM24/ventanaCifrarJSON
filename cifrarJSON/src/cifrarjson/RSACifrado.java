
package cifrarjson;
import java.math.BigInteger;

public class RSACifrado 
{
    private BigInteger n;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    
    public RSACifrado()
    {

    }
    
    public String resultado(String mensaje)
    {
        String resultado = "";
        keygen keygen = new keygen();
        keygen.generarPrimos();
        
        n = keygen.generarN();
        phi = keygen.funcionPhi();
        e = keygen.funcionE();
        d = keygen.funcionD();
        
        System.out.println("Este es n \n " + n);
        System.out.println("Este es e \n " + e);

        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];

        for(int a=0; a<bigdigitos.length;a++){
            temp[0] = digitos[a];
            bigdigitos[a] = new BigInteger(temp);
        }

        BigInteger[] encriptado = new BigInteger[bigdigitos.length];

        for(int i=0; i<bigdigitos.length; i++)
        {
            encriptado[i] = bigdigitos[i].modPow(e,n);
            resultado = resultado + encriptado[i].toString() + "****";
            System.out.println(encriptado[i]);    
        }
        
        System.out.println("El resultado es:\n" + resultado);
        return resultado;
    }
    
}
