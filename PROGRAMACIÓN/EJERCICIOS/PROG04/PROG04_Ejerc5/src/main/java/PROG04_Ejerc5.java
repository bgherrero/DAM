
import java.util.Scanner;

/**
 * Calcula divisiones dados dos números, hasta que ambos números sean -1
 * @author bgher
 */
public class PROG04_Ejerc5 {
    
    public static void main(String[] args) {
        
        // Capturo la excepción durante la ejecución de division       
        try{
            division();
        }catch(ArithmeticException e){
            System.out.println("No se puede dividir entre 0");
        }      
    }
    
    /**
     * Calcula la división de 2 número solicitados hasta que ambos números sean -1
     * @author
     */
    public static void division(){
        
        
        int dividendo= 0; // Primer número solicitado
        int divisor= 0;     // Segundo número solicitado
        int contador = 0; // Se guarda el número de divisiones en esta variable
        Scanner teclado = new Scanner(System.in);
        
        // Sigue calculando divisiones hasta que el dividendo y el divisor sean -1
        while( !(dividendo == -1 && divisor == -1)){
            
            System.out.println("Introduzca el dividendo:");
            dividendo = teclado.nextInt();
            System.out.println("Introduzca el divisor:");
            divisor = teclado.nextInt();

            System.out.printf("El resultado de %d / %d = %d \n", dividendo, divisor, dividendo/divisor);
            contador++; 
            
        }
        // Cuando se termina el bucle muestra el siguente mensaje
        System.out.println("Has realizado " + contador + " divisiones.");
    }
}