
package PROG06_Clases;

import java.time.LocalDate;
import java.time.Period;


/**
 * Clase Vehículo contiene varios atributos y sus métdos get y set.
 * @author bgher
 */
public class Vehiculo{
    
    // Declaración de los atributos de la clase Vehículo
    private String marca;
    private String matricula;
    private int km;
    private LocalDate fechaMatri;
    private String descripcion;
    private int precio;
    private String nomPropietario;
    private String dniPropietario;
    

    /**
     * Constructor de la clase Vehiculo
     * @param marca
     * @param matricula
     * @param km
     * @param diaMatri
     * @param mesMatri
     * @param anioMatri
     * @param descripcion
     * @param precio
     * @param nomPropietario
     * @param dniPropietario 
     */
    public Vehiculo( String marca, String matricula, int km, 
            int anioMatri, int mesMatri, int diaMatri, 
            String descripcion, int precio, 
            String nomPropietario, String dniPropietario){
        
        this.marca = marca;
        this.matricula = matricula;
        this.km = km;
        fechaMatri = LocalDate.of(anioMatri, mesMatri, diaMatri);
        this.descripcion = descripcion;
        this.precio = precio;
        this.nomPropietario = nomPropietario;
        this.dniPropietario = dniPropietario;
        
    }
    //  Creamos los métodos get y set de todos los atributos
    
    /**
     * Método get que devuelve la marca de vehículo
     * @return marca
     */
    public String getMarca() {
        return marca;
    }
    /**
     * Método set para establecer la marca del vehículo
     * @param marca 
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    /**
     * Método get que devuelve la matrícula del vehículo
     * @return matricula
     */
    public String getMatricula() {
        return matricula;
    }
    /**
     * Método set para establecer la matricula del vehículo
     * @param matricula 
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    /**
     * Método get que devuelve los kilómetros del vehículo
     * @return km
     */
    public int getKm() {
        return km;
    }
    /**
     * Método set para establecer los kilómetros del vehículo
     * @param km 
     */
    public void setKm(int km) {
        this.km = km;
    }
    /**
     * Método get que devuelve la fecha de matriculación del vehículo
     * @return fechaMatri
     */
    public LocalDate getFechaMatri() {
        return fechaMatri;
    }
    /**
     * Método set para establecer la fecha de matriculación del vehículo
     * @param fechaMatri 
     */
    public void setFechaMatri(LocalDate fechaMatri) {
        this.fechaMatri = fechaMatri;
    }
    /**
     * Método get que devuelve una descripción del vehículo
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Método set para establecer una descripción del vehículo
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Método get que devuelve el precio del vehículo
     * @return precio
     */
    public int getPrecio(){
        return precio;
    }
    /**
     * Método set para establecer el precio del vehículo
     * @param precio 
     */
    public void setPrecio(int precio){
        this.precio = precio;
    }
    /**
     * Método get que devuelve el nombre del propietario del vehículo
     * @return nomPropietario
     */
    public String getNomPropietario() {
        return nomPropietario;
    }
    /**
     * Método set para establecer el nombre del propietario del vehículo
     * @param nomPropietario 
     */
    public void setNomPropietario(String nomPropietario) {
        this.nomPropietario = nomPropietario;
    }
    /**
     * Método get que devuelve el DNI del propietario del vehículo
     * @return dniPropietario
     */
    public String getDniPropietario() {
        return dniPropietario;
    }
    /**
     * Método set para establecer el DNI del propietario del vehículo
     * @param dniPropietario 
     */
    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }
    /**
     * Calcula los años que tiene el vehículo comparandolo con la fecha actual
     * @return años del vehiculo
     */
    public int get_Anios(){
        
        LocalDate fechaActual = LocalDate.now(); 
        
        Period p = Period.between(fechaMatri, fechaActual);
        
        return p.getYears();
    }
    
}    
