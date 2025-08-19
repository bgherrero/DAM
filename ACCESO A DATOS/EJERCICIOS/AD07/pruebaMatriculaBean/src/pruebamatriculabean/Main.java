
package pruebamatriculabean;

import matricula.MatriculaBean;
/**
 *
 * @author bgher
 */

public class Main {
    public static void main(String[] args) {
        AccedeBD gestion = new AccedeBD();

        System.out.println("Listado de matrículas:");
        gestion.listado();

        System.out.println("\nAñadiendo una nueva matrícula...");
        gestion.anade();
    }
}
