/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG08_Util;

import java.util.regex.*;

/**
 *
 * @author bgher
 */
public class Validar {
    /**
     * Comprueba si una matrícula cumple el formato NNNNLLL. N son números y L son letras
     * @param matricula es el String a comprobar
     * @return true si es correcto el formato y false si no lo es
     */
    public static boolean matriculaCorrecta(String matricula){
        Pattern pat = Pattern.compile("([0-9]{4})([a-zA-Z]{3})");
        Matcher mat = pat.matcher(matricula);
        
        if(mat.matches()){
            return true;
        }else{
            return false;
        }
    }
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
    /**
     * Comprueba que el nombre esté formado por un nombre y dos apellidos y no exceda de 40 caracteres
     * Para ello, cuento los espacios que contiene el String, si son 2 o más es correcto
     * @param nombre es el String a comprobar
     * @return true si es correcto y false si no lo es
     */
    public static boolean nombreCorrecto(String nombre){
        
        int espacios = 0;
        for(int i = 0; i<nombre.length(); i++){
            if( nombre.charAt(i) == ' '){
                espacios++;
            }
        }
        if (nombre.length()<=40 && espacios >= 2)
            return true;
        else
            return false;
    }
}
