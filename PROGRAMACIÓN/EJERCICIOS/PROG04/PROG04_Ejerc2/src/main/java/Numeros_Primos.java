
import java.util.Scanner;

/**
 * Programa que pide por teclado 5 números y si es negativo te lo indica
 * si es positivo te determina si es un número primo o no.
 * @author bgher
 */
public class Numeros_Primos {

    public static void main(String[] args) {
       
        int numero;
        int contador;
        Scanner teclado = new Scanner(System.in);
        
        // Se realiza la comprobación de 5 números, por ello el contador va desde el 1 al 5        
        for (contador = 1; contador <= 5; contador++){
            
            // Se solicita el número
            System.out.println("Escribe un número: ");
            numero = teclado.nextInt();
            
            // Primero se comprueba si es negativo
            if (numero < 0){
                System.out.println("El número es negativo.");
            }
            
            // Si es positivo se determina si es número primo o no con el método esPrimo
            else if (numero > 0) {
                if (esPrimo(numero) == true){
                    System.out.println("El número " + numero + " es primo");
                }
                else if (esPrimo(numero) == false){
                    System.out.println("El número " + numero + " no es primo");
                }
            }
        }
        
    }
    /**
     * Determina si un número es primo o no
     * @param numero: el número a investigar
     * @return si es o no un número primo
     */
    public static boolean esPrimo(int numero){
        // Los número 0 y 1 no son primos
        if (numero == 0 || numero == 1){
            return false;
        }
        else {
            // Los números que sean divisibles por algún número estre 2 y el propio número no son primos
            for (int i = 2; i < numero; i++){
                if (numero % i == 0){
                    return false;
                }
            }
            return true;
        }
        
    }
}
