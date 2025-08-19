
package prog09_clases;

/**
 * Es un tipo de CuentaCorriente que a su vez es un tipo de CuentaBancaria
 * @author bgher
 */
public class CuentaCorrientePersonal extends CuentaCorriente{
    
    // Atributos propios de esta clase
    private final double comisionMantenimiento;
    
    // Constructor    
    public CuentaCorrientePersonal(Persona titular, double saldoActual, String iban, 
                                String entidadesAutorizadas, 
                                double comisionMantenimiento){
        super(titular,saldoActual, iban, entidadesAutorizadas);
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
    // Redefinición de los métodos de la interfaz Imprimible
    @Override
    public String devolverInfoString() {
        return "CUENTA CORRIENTE PERSONAL{"
                + super.devolverInfoString() 
                + "Comisión de mantenimiento: "+comisionMantenimiento+"} " ;
    }
    
}
