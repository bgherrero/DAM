import java.util.Scanner;
/**
 *
 * @author bgher
 */
public class PROG02_Ejerc9 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Inserte un año: ");
        int año = teclado.nextInt();
        
        if ((año%4 == 0 && año%100 != 0) || (año%100 == 0 && año%400 == 0)){
            System.out.print(año + " es bisiesto");
        }
        else{
            System.out.print(año + " no es bisiesto");
        }
    }
}
