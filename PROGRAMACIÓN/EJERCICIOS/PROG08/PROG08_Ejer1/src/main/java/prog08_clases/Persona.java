package prog08_clases;

import prog08_util.Imprimible;

/**
 *
 * @author bgher
 */
public class Persona implements Imprimible{
    // Atritubos de la clase
    private String nombre;
    private String apellidos;
    private String DNI;
    
    // Constructor de la clase
    public Persona(String nombre, String apellidos, String DNI){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
    }
    
    // Métodos GET de todos los atributos para poder acceder a estos datos desde fuera de la clase
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDNI() {
        return DNI;
    }

    @Override
    public String toString() {
        return "titular= " + nombre +" "+ apellidos + ", DNI=" + DNI;
    }
    
    // Redefinición de los métodos de la interfaz Imprimible
    @Override
    public String devolverInfoString() {
        return "Titular: " + nombre +" "+ apellidos+". "
                + "DNI: " + DNI+". " ;
    }
    
}
