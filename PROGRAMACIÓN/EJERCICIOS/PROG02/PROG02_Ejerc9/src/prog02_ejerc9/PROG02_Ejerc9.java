/*
 * Dado un año, decir si es bisiesto o no.
 * Bisiesto = tiene que ser divisible por 4 pero no por 100 salvo que sea divisible por 400
 */
package prog02_ejerc9;
import java.util.Scanner;
/**
 *
 * @author bgher
 */
public class PROG02_Ejerc9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner ( System.in);
        
        System.out.print(" Escribe un año: ");
        int año = teclado.nextInt();
        
        
        if ((año % 4 == 0) && (año % 100 != 0) || (año % 400 == 0)) {
            System.out.println(año + " es un año bisiesto");
            }
        else {
            System.out.println(año + " no es un año bisiesto");
            }
                
    }
    
}
