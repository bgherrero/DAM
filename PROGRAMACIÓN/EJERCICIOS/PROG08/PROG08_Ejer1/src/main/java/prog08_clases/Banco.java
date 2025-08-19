
package prog08_clases;

import java.util.ArrayList;

/**
 * La clase Banco almacenará todas las cuentas bancarias
 * Ulilizo ArrayList porque de esta forma la lista se va redimensionando conforme se necesita más espacio o menos
 * @author bgher
 */
public class Banco {
    private ArrayList <CuentaBancaria> banco;
    // Constructor
    public Banco(){
        this.banco = new ArrayList<>();
    }
    /**
     * Comprueba que la cuenta existe, comprobando si el iban está en el array banco
     * @param iban
     * @return CuentaBancaria si existe, si no null
     */
    public CuentaBancaria buscarIban(String iban){
        for(CuentaBancaria c: this.banco ){
            if (c.getIban().equals(iban)){
                CuentaBancaria cuenta = c;
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
        
        if (this.buscarIban(cuenta.getIban()) != null){
                System.out.println("La cuenta ya existe.");
                return false;
        }
        this.banco.add(cuenta);
        return true;       
    }
    /**
     * Muestra la información de todas las cuentas almacenadas en el banco
     * @return un array con la información 
     */
    public String[] listadoCuentas(){
        String [] infoCuentas = new String[this.banco.size()];
        
        for( int i = 0; i < infoCuentas.length; i++){
            infoCuentas[i] = this.banco.get(i).toString();
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
    /**
     * Elimina una cuenta del banco dado un iban siempre que la cuenta tenga de saldo cero
     * @param iban
     * @return 
     */
    public boolean eliminarCuenta(String iban){
        CuentaBancaria cuenta = this.buscarIban(iban);
        if (cuenta != null){
            if (cuenta.getSaldoActual() == 0){
                this.banco.remove(cuenta);
                return true;
            }else{
                System.out.println("El saldo de esta cuenta no es cero.");
                return false;
            }
        }else{
            System.out.println("Esta cuenta no existe.");
            return false;
        }
    }
        
}
