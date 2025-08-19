package prog02_ejerc4;

import java.util.Scanner;


/**
 *
 * @author bgher
 */
public class PROG02_Ejerc4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // clase Scanner para petición de datos
        Scanner teclado = new Scanner(System.in);
        int edad;
        // pedimos la edad del usuario y la guardamos en la variable edad
        System.out.print( "Por favor introduzca su edad:");
        edad = teclado.nextInt();
        
        int mayorEdad = 18;
        System.out.println(edad >= mayorEdad ? "¡Eres mayor de edad!": "Eres muy joven todavía");
                
    }
    
}
