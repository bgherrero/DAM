
package prog07_util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Para validar el formato de los datos introducidos
 * @author bgher
 */
public class Validar {    
    
    /**
     * Comprueba si el formato de un DNI es correcto:
     * puede empezar por una letra, luego son de 1 a 9 números y termina con una letra
     * @param dni es el String a comprobar
     * @return true si es correcto el formato y false si no lo es
     */
    public static boolean dniCorrecto(String dni){
        Pattern pat = Pattern.compile("^([a-zA-Z]?)([0-9]{1,9})([a-zA-Z])$");
        Matcher mat = pat.matcher(dni);
        
        if(mat.matches()){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean ibanCorrecto(String iban){
        Pattern pat = Pattern.compile("^ES[0-9]{20}$");
        Matcher mat = pat.matcher(iban);
        
        if(mat.matches()){
            return true;
        }else{
            return false;
        }
    }
}
