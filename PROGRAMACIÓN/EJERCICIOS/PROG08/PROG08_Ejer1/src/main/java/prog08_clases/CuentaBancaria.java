package prog08_clases;

import prog08_util.Imprimible;

/**
 * CuentaBancaria puede ser de dos tipos, CuentaAhorro o CuentaCorriente, que a su vez esta última
 * puede ser CuentaCorrientePersonal o CuentaCorrienteEmpresa
 * @author bgher
 */
public abstract class CuentaBancaria implements Imprimible{
    
    // Atributos de la clase
    private Persona titular;
    private double saldoActual;
    private String iban;
    
    // Constructor de la clase
    public CuentaBancaria(Persona titular, double saldoActual, String iban){
        this.titular = titular;
        this.saldoActual = saldoActual;
        this.iban = iban;
    }
    
    // Métodos Get y Set 
    public String getIban() {
        return iban;
    }
    public Persona getTitular() {
        return titular;
    }
    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + titular.toString()+ ", saldo=" + saldoActual + ", iban=" + iban + '}';
    }
    
    // Redefinición de los métodos de la interfaz Imprimible
    @Override
    public String devolverInfoString(){
        return titular.devolverInfoString() +". "
                + "Saldo: " + saldoActual+ ". "
                + "IBAN: "+iban+ ". ";
    }
    
}
