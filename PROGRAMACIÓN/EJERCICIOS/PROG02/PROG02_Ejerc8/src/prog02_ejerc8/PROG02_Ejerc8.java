/**
 * Dados el número de alumnos matriculados en cada asignatura, el programa mostrará el %
 * de alumnos matriculados en cada módulo. Cada alumno sólo puede matricularse en un módulo.
 */
package prog02_ejerc8;
import java.util.Scanner;
/**
 *
 * @author bgher
 */
public class PROG02_Ejerc8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        
        System.out.print("Alumnos matriculados en Programación: ");
        float prog = teclado.nextInt();
        System.out.print("Alumnos matriculados en Entornos de Desarrollo: ");
        float ed = teclado.nextInt();
        System.out.print("Alumnos matriculados en Base de datos: ");
        float bd = teclado.nextInt();
        
        float total = prog + ed + bd;
        System.out.println("Total de alumnos :" + total);
        float pProg = (prog *100) / total;
        float pEd = (ed *100) / total;
        float pBd = (bd *100) / total;
        
        System.out.printf("Porcentaje de alumnos matriculados en Programación: %.1f \n", pProg);
        System.out.printf("Porcentaje de alumnos matriculados en Entorno de Desarrollos: %.1f \n", pEd);
        System.out.printf("Porcentaje de alumnos matriculados en Base de datos: %.1f \n", pBd);
        
    }
  
}
