import java.util.Scanner;
/**
 *
 * @author bgher
 */
public class PROG02_Ejerc7 {

    public static void main(String[] args) {
        // Creo las variables
        int C1;
        int C2;
        Scanner teclado = new Scanner(System.in);
        // Solicito dos número
        System.out.printf("Escriba el primer número: ");
        C1 = teclado.nextInt();
        System.out.printf("Escriba el segundo número: ");
        C2 = teclado.nextInt();
        // Resuelvo la ecuación y muestro el resultado
        float x = (float)-C2 / C1;
        
        System.out.printf("En la ecuación %d * x + %d = 0" + "\n x = %.4f", C1, C2, x);
    }
}
