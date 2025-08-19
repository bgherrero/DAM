
import java.util.Scanner;

/**
 * Juego para adivinar un número oculo
 * @author bgher
 */
public class Numero_Oculto {
    
    public static void main(String[] args) {
        
        int menu; 
        int numInt = 5; // Número de intentos permitidos
        int numMax = 10; // Número máximo generado
        int numJugador; // Número con el que intenta acertar el jugador
        int contador = 0;   // Variable que va contando los intentos
        boolean salir = false; // Cuando salir == true, saldremos del programa
        Scanner teclado = new Scanner(System.in);
        
        // Hasta que no demos a salir, el programa seguirá funcionando
        while (!salir){
            
             // Primero hay que elegir lo que quieres hacer
            System.out.println("Seleccione una opción: \n1.Configurar \n2.Jugar \n3.Salir");
            menu = teclado.nextInt();
            
            switch (menu){
                
                case 1: // Se configura el número de intentos y el número máximo a adivinar
                
                    System.out.println("Número de intentos permitidos: ");
                    numInt = teclado.nextInt();
                
                    System.out.println("Número máximo a adivinar: ");
                    numMax = teclado.nextInt();
                    break;
                 
                
                case 2: // Jugar
                    // Genera un número aleatorio entre 0 y numMax, ambos incluidos
                    int numOculto = (int)Math.floor(Math.random()*numMax+1);
                        
                        // Hasta que no adivinemos el número o superemos el númer de intentos sigue este bucle
                        do{
                            System.out.println("Adivina un número entre 0 y " + numMax);
                            numJugador = teclado.nextInt();
                            contador++;
                        
                            if (numJugador != numOculto){
                                
                                // Nos da pista si el número oculto es mayor o menor
                                if (numJugador < numOculto){
                                    System.out.println("El número a adivinar es mayor");
                                }
                                else if (numJugador > numOculto){
                                    System.out.println("El número a adivinar es menor");
                                }
                                
                            // Si se acierta, hemos ganado y vuelve al menú    
                            } else if (numJugador == numOculto){
                                System.out.println("Has ganado! Has necesitado " +contador+ " intentos");
                                contador = 0;
                                break;
                            }               
                        }while(contador < numInt);
                    
                    // Si superamos el número de intentos perdemos
                    if (contador >= numInt){
                        System.out.println("Perdiste! Intentos consumidos");
                        contador = 0;
                    }
                    break;
            
                case 3: // Salir
                
                    System.out.println("Juego finalizado");
                    salir = true;
                    break;
            }
        }
    }
}
