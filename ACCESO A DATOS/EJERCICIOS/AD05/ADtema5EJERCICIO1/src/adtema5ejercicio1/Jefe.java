/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adtema5ejercicio1;

/**
 *
 * @author bgher
 */
public class Jefe {
    private String nombre;
    private int antiguedad;
    private int edad;
    private Hijo hijo;
    // Constructores
    public Jefe(String nombre, int antiguedad, int edad, Hijo hijo) {
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.edad = edad;
        this.hijo = hijo;
    }

    public Jefe() {
    }
    // Métodos básicos para asigna y obtener valores de atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Hijo getHijo() {
        return hijo;
    }

    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }
    // Devuelve los atributos de un objeto
    @Override
    public String toString() {
        return "Jefe{" + "nombre=" + nombre + ", antiguedad=" + antiguedad + ", edad=" + edad + ", hijo=" + hijo + '}';
    }
    
}
