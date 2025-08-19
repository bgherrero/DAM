/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ejer1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


/**
 *
 * @author bgher
 */
public class Parte1 {

    public static void main(String[] args) {
        // Creo una ArrayList donde se almacenan todos los empleados que voy añadiendo
        ArrayList<Empleado>  empleados = new ArrayList<>();
        // Inserto los empleados
        empleados.add(new Empleado(1, "Alejandra", "Avenida Mayor", 20000, 500));
        empleados.add(new Empleado(2, "Berta", "Calle menor", 10000, 125));
        empleados.add(new Empleado(3, "Carolina", "Plaza de java", 35000, 750));
        empleados.add(new Empleado(4, "Diana", "Paseo de la infromática", 15000, 400));
        empleados.add(new Empleado(5, "Esther", "Ronda random", 20000, 2000));
        // Escribo los empleados en el archivo
        try {
            RandomAccessFile raf = new RandomAccessFile("EMPLEADOS.DAT", "rw");
            
            for (Empleado e: empleados){                
                e.escribirEnArchivo(raf);                
            }
            System.out.println("Fichero EMPLEADOS.DAT creado correctamente.");
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
                }
        
        
        
        
    }
}
