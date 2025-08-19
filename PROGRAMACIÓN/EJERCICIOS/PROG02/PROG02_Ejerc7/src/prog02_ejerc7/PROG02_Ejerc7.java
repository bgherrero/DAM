/*
 * resolver una ecuación de primer grado con una incógnita (x)
 * 
 */
package prog02_ejerc7;
import java.util.Scanner;
/**
 *
 * @author bgher
 */
public class PROG02_Ejerc7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 
        Scanner teclado = new Scanner(System.in);
        float C1;
        float C2;
        float x;
        // solicitamos dos números
        System.out.print("Escriba un número: ");
        C1 = teclado.nextFloat();
        System.out.print("Escriba otro número: ");
        C2 = teclado.nextFloat();        
        
        x = -C2 / C1;
        System.out.printf("El resultado de la ecuación %.4f*x + %.4f = %.4f\n", C1, C2, x);
    }
    
}
