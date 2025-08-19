
import java.util.Scanner;


/**
 * Programa que muestra la tabla de multiplicar de un número leido desde teclado
 * utilizando al menos tres bucles diferentes. El número leído ha de ser menor que 30.
 * @author bgher
 */
public class TablaMultiplicar {
     
    
    public static void main(String[] args) {
        // Declaración de las variables   
        int metodo;
        int numero;
        int contador = 1;
        Scanner teclado = new Scanner(System.in);
        
        // Se solicita el número que se ha de multiplicar
        System.out.println("Introduzca un número inferior a 30: ");
        numero = teclado.nextInt();
        // En caso de que el número introducido sea mayor que 30, se termina el programa
        if (numero > 30){
            System.out.println("El número tiene que ser inferior a 30.");
            return;
        }
        
        // Se solicita el método a utilizar para realizar la tabla de multiplicar
        System.out.println("""
                           Elige método:
                            1. for
                            2. while
                            3. do-while""");
        metodo = teclado.nextInt();
                
        /* Dependiendo del método elegido, se utilizara el caso 1, 2 o 3 para realizar el bucle
        * Utilizo el contador, que se va incrementando en cada vuelta para realizar el bucle 10 veces
        * y escribir la tabla de multiplicar completa
        */
        switch (metodo){
            case 1 :
                System.out.println("La tabla de multiplicar del número " + numero + ":");                
                for (contador=1; contador <=10; contador++){
                    System.out.println(numero + " X " + contador + " = " + (numero*contador) );
                }
                break;
                
            case 2: 
                System.out.println("La tabla de multiplicar del número " + numero + ":");
                while (contador<=10){
                    System.out.println(numero + " X " + contador + " = " + (numero*contador) );
                    contador++;
                }
                break;
                
            case 3:
                System.out.println("La tabla de multiplicar del número " + numero + ":");
                do {
                    System.out.println(numero + " X " + contador + " = " + (numero*contador) );
                    contador++;
                }while (contador<=10);
                break;
                
            // En el caso de no introducir 1,2 o 3, la tabla de multiplicar no se ejecuta    
            default:
                if (metodo != 1 || metodo != 2 || metodo != 3){
                    System.out.println("Ese método no existe.");
                    
                }
        }
        
    }
    
}
