package com.prog03.figuras;

/**
 *
 * @author bgher
 */
public class Rectangulo {
    
    // Atributos
    private float base;
    private float altura;
    
    // Constructores
    public Rectangulo(){
        
    }
        public Rectangulo(float base, float altura){
        this.base = base;
        this.altura = altura;
    }
        
    // Métodos set
    public void setBase(float base){
        this.base = base;
    }  
    public  void setAltura(float altura){
        this.altura = altura;
    }
    
    // Métodos get
    public float getBase(){
        return base;
    }
    public float getAltura(){
        return altura;
    }
    
    // Método que devuelve el área del rectángulo
    public float getArea(){
        float area= base * altura;
        return area;
    }
    
    // Método que devuelve una cadena conteniendo su área y su altura
    public String toString(){
        return "El área es " + base*altura + " y su altura es " + altura;
    }
    
    // Método que nos devuelve un booleano indicando si el rectángulo es cuadrado
    public boolean isCuadrado(){
        if ( base == altura){
            return true;
        }
        else {
            return false;
        }
    }
    
}
