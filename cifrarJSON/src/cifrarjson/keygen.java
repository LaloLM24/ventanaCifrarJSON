package cifrarjson;
import java.security.SecureRandom;
import java.math.BigInteger;


public class keygen 
{
    private BigInteger p , q;
    private BigInteger n;
    private BigInteger phi, e, d;

    public keygen()
    {
    }
    
    public BigInteger numeroPrimo()
    {
        BigInteger numeroPrimo = null;
        
        try
        {
            SecureRandom generador = SecureRandom.getInstance("SHA1PRNG");
            numeroPrimo = new BigInteger(64, generador);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        return numeroPrimo;
    }
    
    public void generarPrimos()
    {
        p = numeroPrimo();
        System.out.println(p);
        q = numeroPrimo();
        System.out.println(q);
    }
    
   
    public BigInteger generarN()
    { 
        n = p.multiply(q);
        System.out.println(n);
        return n;
    }
    
    
    public BigInteger funcionPhi()
    {
        phi = p.subtract(BigInteger.valueOf(1));
        phi = phi.multiply(q.subtract(BigInteger.valueOf(1)));
        return phi;
    }
    
    
    public BigInteger funcionE()
    {
        do 
        {
            e = new BigInteger(128, new SecureRandom());
        }
        while((e.compareTo(phi)!=-1 || e.gcd(phi).compareTo(BigInteger.valueOf(1))!= 0));
        return e;
    }
    
    public BigInteger funcionD()
    {
        d = e.modInverse(phi);
        return d;
    }
}
