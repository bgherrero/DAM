/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog07_clases;

/**
 * Es un tipo de CuentaBancaria
 * @author bgher
 */
public class CuentaAhorro extends CuentaBancaria{
    
    // Atributos de la clase
    private double interesAnual;
    
    // Constructor de la clase
    public CuentaAhorro( Persona titular, double saldoActual, String iban, double interesAnual){
        super(titular, saldoActual, iban);
        this.interesAnual = interesAnual;
    }
    
    // Redefinición de los métodos de la interfaz Imprimible
    @Override
    public String devolverInfoString() {
        return "CUENTA DE AHORROS{ "
                + super.devolverInfoString()
                + "Interés anual: "+this.interesAnual+"} " ;
    }
}
