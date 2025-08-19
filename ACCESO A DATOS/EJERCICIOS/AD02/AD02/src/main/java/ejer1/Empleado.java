
package ejer1;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author bgher
 */
public class Empleado {
    // Atributos
    private int codigo;
    private String nombre;
    private String direccion;
    private float salario;
    private float comision;
    
    /**
     * Método constructor de la clase Empleado
     * @param codigo
     * @param nombre
     * @param direccion
     * @param salario
     * @param comision 
     */
    public Empleado(int codigo, String nombre, String direccion, float salario, float comision) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.salario = salario;
        this.comision = comision;
    }
    /**
     * Escribe en el archivo dado todos los Empleados insertados
     * @param file: archivo donde se escriben todos los empleados
     * @throws IOException 
     */
    public void escribirEnArchivo(RandomAccessFile file) throws IOException{
        
        file.writeInt(codigo);
        // Se utiliza una longitud fija de 30 para el nombre, rellenando con espacios si la longitud es menor
        StringBuilder sb = new StringBuilder(nombre);
        sb.setLength(30);
        file.writeChars(sb.toString());
        // Se utiliza una longitud fija de 50 para la dirección, rellenando con espacios si la longitud es menor
        sb = new StringBuilder(direccion);
        sb.setLength(50);
        file.writeChars(sb.toString());
        
        file.writeFloat(salario);
        file.writeFloat(comision);        
    }
    
    // Métodos Get y Set de todos los atributos
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }
    
     
}
