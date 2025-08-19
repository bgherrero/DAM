
package PROG05_Ejerc1_util;

import static java.lang.Character.toUpperCase;
import java.time.LocalDate;

/**
 * Clase Validar contiene los métodos estáticos para realizar
 * las diferentes comprobaciones que se necesiten
 * @author bgher
 */
public class Validar {
    /**
     * Comprueba si el número es > 0, positibo
     * @param km
     * @return true si es positivo, false si es negativo
     */
    public static boolean kmCorrecto(int km){
        if (km > 0){ 
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Compruega si la fecha es anterior al dia actual
     * @param anio
     * @param mes
     * @param dia
     * @return true si la fecha es correcta, false si es incorrecta 
     */
    public static boolean fechaCorrecta( int anio, int mes, int dia){
        
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        if(fecha.isBefore(LocalDate.now())){
            return true;            
        }else{
            return false;
        }
    }
     /**
      * Comprueba si el DNI es correcto
      * @param dni
      * @return true si el dni es correcto, false si es erroneo
      */
    public static boolean dniCorrecto(String dni){
        boolean valido= true;
        char letra_leida;
        char letra_calculada;
        int numDni;
        
        if (dni == null){
            valido = false;
        }           // el dni ha de tener 8 u 9 caracteres
        else if (dni.length()<8 || dni.length()>9) {
            valido = false;
        }           // aquí se comprueba si la letra del dni es correcta
        else{
            letra_leida = DNI.extraerLetraDNI(dni);
            numDni = DNI.extraerNumeroDNI(dni);
            letra_calculada = DNI.calcularLetraDNI(numDni);
            if (toUpperCase(letra_leida) == letra_calculada){
                valido = true;
            }
            else{
                valido = false;
            }
        }
        return valido;
        
    }
 
}    
/**
 * Clase DNI contiene varios métodos estáticos que nos ayudan 
 * a manipular los números y la letra del DNI
 * @author bgher
 */
class DNI{
    
    private String dni;
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    /**
     * Dado un número de dni, calcula la letra
     * @param numDni 
     * @return letraDni
     */
    static char calcularLetraDNI(int numDni){
        
        char letraDni;
        letraDni = LETRAS_DNI.charAt( numDni % 23);
        return letraDni;
    }
    /**
     * Dado un dni, extrae la letra, que el el último caracter del String
     * @param dni
     * @return letraDni
     */
    static char extraerLetraDNI(String dni){
        char letraDni = dni.charAt(dni.length()-1);
        return letraDni;
    }
    /**
     * Dado un dni, extrae los número, que son todos los caracteres menos el último
     * @param dni
     * @return numDni
     */
    static int extraerNumeroDNI(String dni){
        int numDni = Integer.parseInt(dni.substring(0,dni.length()-1));
        return numDni;
    }
    
    
}