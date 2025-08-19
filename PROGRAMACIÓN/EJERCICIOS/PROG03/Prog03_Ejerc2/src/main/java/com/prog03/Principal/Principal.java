package com.prog03.Principal;
import com.prog03.figuras.Rectangulo;
/**
 *
 * @author bgher
 */
public class Principal {

    public static void main(String[] args) {
        
        Rectangulo obj1 = new Rectangulo();
        obj1.setAltura(5.2f);
        obj1.setBase(7.8f);
        
        System.out.println("El área del obj1 es " + obj1.getArea());
        System.out.println( obj1.toString());
        System.out.println( obj1.isCuadrado()? "Es cuadrado" : "No es cuadrado" );
        
        Rectangulo obj2 = new Rectangulo(8,4);
        obj2.setAltura(8);
        System.out.println("\nEl área del obj2 es " + obj1.getArea());
        System.out.println( obj2.toString());
        System.out.println( obj2.isCuadrado()? "Es cuadrado" : "No es cuadrado" );
    }
}
