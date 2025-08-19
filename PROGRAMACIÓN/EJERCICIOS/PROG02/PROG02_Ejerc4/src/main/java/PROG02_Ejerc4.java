import java.util.Scanner;
/**
 * Programa que dada la edad de una persona muestre un mensaje
 * indicando si es mayor de edad o no
 * @author bgher
 */
public class PROG02_Ejerc4 {

    public static void main(String[] args) {
        int edad;
        final int MAYOR_EDAD = 18;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduzca su edad:");
        edad = teclado.nextInt();
        
        System.out.println(edad >= MAYOR_EDAD ? "¡Eres mayor de edad!" : "Eres muy joven todavía" );
    }
}
