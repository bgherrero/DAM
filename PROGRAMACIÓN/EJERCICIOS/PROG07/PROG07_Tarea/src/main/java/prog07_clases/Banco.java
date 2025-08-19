/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog07_clases;

/**
 * La clase Banco almacenará todas las cuentas bancarias
 * @author bgher
 */
public class Banco {
    private CuentaBancaria[] banco;
    private int contador = 0;
    // Constructor
    public Banco(){
        this.banco = new CuentaBancaria[100];
    }
    /**
     * Comprueba que la cuenta existe, comprobando si el iban está en el array banco
     * @param iban
     * @return CuentaBancaria si existe, si no null
     */
    public CuentaBancaria buscarIban(String iban){
        for( int i = 0; i < this.contador; i++){
            if (this.banco[i].getIban().equals(iban)){
                CuentaBancaria cuenta = this.banco[i];
                return cuenta;
            }            
        }
        return null;
    }
    /**
     * Inserta un objeto CuentaBancaria en el array banco, con un límite de 100
     * @param cuenta
     * @return true si se realiza correctamente
     */
    public boolean abrirCuenta(CuentaBancaria cuenta){
        if(this.contador >=100){
            System.out.println("Ha alcanzado el límite de cuentas para almacenar en el banco.");
            return false;
        }
        
        if (this.buscarIban(cuenta.getIban()) != null){
                System.out.println("La cuenta ya existe.");
                return false;
        }
        this.banco[this.contador] = cuenta;
        this.contador ++;
        return true;       
    }
    /**
     * Muestra la información de todas las cuentas almacenadas en el banco
     * @return un array con la información 
     */
    public String[] listadoCuentas(){
        String [] infoCuentas = new String[this.contador];
        
        for( int i = 0; i < this.contador; i++){
            infoCuentas[i] = this.banco[i].toString();
        }
        return infoCuentas;
    }    
    /**
     * Muestra la información de una cuenta dado un iban
     * @param iban
     * @return String con la información de la cuenta
     */
    public String informacionCuenta(String iban){
        CuentaBancaria cuenta = this.buscarIban(iban);
        if(cuenta != null){
            return cuenta.devolverInfoString();
        }
        return null;        
    }
    /**
     * Aumente el saldoActual de una cuenta
     * @param iban 
     * @param ingreso
     * @return true si se realiza correctamente
     */
    public boolean ingresoCuenta( String iban, double ingreso){
        CuentaBancaria cuenta = this.buscarIban(iban);
        if(cuenta != null){
            cuenta.setSaldoActual(cuenta.getSaldoActual()+ingreso);
            return true;
        }
        return false;
    }
    /**
     * Si hay saldo suficiente en la cuenta, retira una cierta cantidad de dinero
     * @param iban
     * @param retirada
     * @return true si se realiza correctamente
     */
    public boolean retiradaCuenta(String iban, double retirada){
        CuentaBancaria cuenta = this.buscarIban(iban);
        if(cuenta != null){
            if (cuenta.getSaldoActual()>= retirada){
                cuenta.setSaldoActual(cuenta.getSaldoActual()-retirada);
                return true;
            }else{
                System.out.println("No hay disponible saldo suficiente para efectuar esa retirada.");
                return false;
            }            
        }else{
            System.out.println("Esa cuenta no existe.");
        }
        return false;
    }
    /**
     * Nos muestra el saldo de una cuenta dado un iban
     * @param iban
     * @return el saldoActual o -1 si no ha sido posible
     */
    public double obtenerSaldo(String iban){
        CuentaBancaria cuenta = this.buscarIban(iban);
        if(cuenta != null){
            return cuenta.getSaldoActual();
        }
        return -1;
    }
        
}
