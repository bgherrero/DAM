import java.util.Scanner;

/**
 *
 * @author bgher
 */
public class PROG02_Ejerc5 {

    public static void main(String[] args) {
        // Declaro las variables
        int seg;
        int min;
        int hora;
        int dia;
        Scanner teclado = new Scanner(System.in);
        // Solicito que inserten un número de segundos y lo guardo en la variable seg
        System.out.println("Inserte un número de segundos:");
        seg = teclado.nextInt();
        /* Calculo los días, hora y minutos 
        (1 día= 86400 segundos, 1 hora = 3600 segundos, 1 minuto = 60 segundos)*/
        if (seg >= 86400){
            dia = seg / 86400;
            hora = (seg - (dia*86400))/3600;
            min = (seg - (dia*86400) - (hora*3600))/60;
        }
        else{
            dia = 0;
            if ( seg >=3600){
                hora = seg / 3600;
                min = (seg - (hora*3600))/60;
            }     
            else{
                hora = 0;
                min = seg / 60;
            }
        }
        // Mostramos los resultados
        System.out.printf("%d segundos son: %d días, %d horas, %d minutos", seg, dia, hora, min);
    }
}
