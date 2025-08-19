
import java.util.Scanner;


/**
 *
 * @author bgher
 */
public class PROG04_Ejerc3 {
    /**
     * Calcula el Minimo Común Múltiplo de 2 números (n1 y n2)
     * @param n1 primer número
     * @param n2 segundo número
     * @return el mcm de los dos números
     */
    public static int mcm(int n1, int n2){ // n1= 2 n2= 5 nMax = 5
        // Se determina cual es mayor de los dos números y se guarda en nMax
        int nMax = (n1>n2 )? n1:n2;
        /** Se calcula si nMax es el mcm, es decir si al dividirlo por los dos 
         * números el resto es cero. Si no lo es para n1 y n2, nMax aumenta su 
         * valor en 1 y se vuelve a comprobar.
         *  
         */
                // 5 % 2 = 1       5 % 5 = 0
                //      TRUE    ||    FALSE
                //              TRUE
        while ((nMax % n1 != 0) || (nMax % n2 != 0)){
            nMax ++; // 5+1=6 = nMax. Se vuelve a comprobar con 6, hasta el valor 10 que es el mcm
        }
        return nMax;
       
    }

    public static void main(String[] args) {
        
        int n1;
        int n2;
        int mcm;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Inserte el primer número: ");
        n1 = teclado.nextInt();
        
        System.out.println("Inserte el segundo número: ");
        n2 = teclado.nextInt();
        
        if (n1 < 0 || n2 < 0){
            System.out.println("Los número introducidos no son correctos.");
        }
        
        else {
            mcm = mcm(n1, n2);
            System.out.printf("El mínimo comun múltipo de %d y %d es %d\n", n1, n2, mcm);
        }
    }
    
}
