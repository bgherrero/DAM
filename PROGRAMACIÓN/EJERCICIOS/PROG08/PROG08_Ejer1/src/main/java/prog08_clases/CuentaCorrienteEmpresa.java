
package prog08_clases;

/**
 * Es un tipo de CuentaCorriente que a su vez es un tipo de CuentaBancaria
 * @author bgher
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente{
    
    // Atributos propios de esta clase
    private double maxDescubierto;
    private double interesDescubierto;
    private double comisionDescubierto;
    
    // Constructor
    public CuentaCorrienteEmpresa(Persona titular, double saldoActual, String iban, 
                                String entidadesAutorizadas, 
                                double maxDescubierto, double interesDescubierto, double comisionDescubierto){
        super(titular,saldoActual, iban, entidadesAutorizadas);
        this.maxDescubierto = maxDescubierto;
        this.interesDescubierto = interesDescubierto;
        this.comisionDescubierto = comisionDescubierto;
    }
    
    // Redefinición de los métodos de la interfaz Imprimible
    @Override
    public String devolverInfoString() {
        return "CUENTA CORRIENTE EMPRESA{"
                + super.devolverInfoString() 
                + "Máximo descubierto: "+maxDescubierto+". "
                + "Tipo de interés por descubierto: "+interesDescubierto+". "
                + "Comisión fija por cada descubierto: "+comisionDescubierto+"} " ;
    }
}
