
package prog09_clases;

/**
 * Es un tipo de CuentaBancaria
 * @author bgher
 */
public abstract class CuentaCorriente extends CuentaBancaria {
    
    // Atributos de la clase
    private String entidadesAutorizadas;
    
    // Constructor de la clase
    public CuentaCorriente( Persona titular, double saldoActual, String iban, String entidadesAutorizadas){
        super(titular, saldoActual, iban);
        this.entidadesAutorizadas = entidadesAutorizadas;
    }
    
    // Redefinición de los métodos de la interfaz Imprimible
    @Override
        public String devolverInfoString() {
            return  super.devolverInfoString() 
                    + "Lista de entidades: "+entidadesAutorizadas+". " ;
        }
    
}
