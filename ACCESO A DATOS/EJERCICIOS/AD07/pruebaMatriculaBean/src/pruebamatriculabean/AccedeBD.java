
package pruebamatriculabean;

/**
 *
 * @author bgher
 */
import matricula.MatriculaBean;
import matricula.MatriculaBean.BDModificadaEvent;
import matricula.MatriculaBean.BDModificadaListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccedeBD implements BDModificadaListener {

    MatriculaBean matriculas;

    public AccedeBD() {
        matriculas = new MatriculaBean();
        matriculas.addBDModificadaListener(this);
    }
    public void listado() {
        matriculas.cargarMatriculas();
        for (int i = 0; i < 4; i++) {
            matriculas.seleccionarFila(i);
            System.out.println("Matrícula " + i + "\n\tDNI: " + matriculas.getDNI());
            System.out.println("\tNombre Módulo: " + matriculas.getNombreModulo());
            System.out.println("\tCurso: " + matriculas.getCurso());
            System.out.println("\tNota: " + matriculas.getNota());
        }
    }
    public void anade() {
        matriculas.setDNI("98765432A");
        matriculas.setNombreModulo("Inglés");
        matriculas.setCurso("24-25");
        matriculas.setNota(9.5);
        try {
            matriculas.addMatricula();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccedeBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void capturarBDModificada(BDModificadaEvent ev) {
        System.out.println("Se ha añadido una nueva matrícula a la base de datos.");
    }
}
