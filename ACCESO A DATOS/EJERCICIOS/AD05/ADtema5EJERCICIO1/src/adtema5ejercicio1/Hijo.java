/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adtema5ejercicio1;

/**
 * 
 * @author bgher
 */
public class Hijo {
    private String nombre;
    private int edad;
    // Constructores
    public Hijo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public Hijo() {
    }
    // Métodos básicos para asigna y obtener valores de atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    // Devuelve los atributos de un objeto
    @Override
    public String toString() {
        return "Hijo{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
    
}
