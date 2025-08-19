
package Vehiculo;


/**
 * Clase Vehículo contiene varios atributos y sus métdos get y set.
 * @author bgher
 */
public class Vehiculo{
    
    // Declaración de los atributos de la clase Vehículo
    public String marca;
    public String matricula;
    public int km;
    public String fechaMatri;
    public int precio;
    public String nomPropietario;
    
    public Vehiculo(String marca, String matricula, int km, String fechaMatri, int precio, String nomPropietario){
        this.marca = marca;
        this.matricula = matricula;
        this.km = km;
        this.fechaMatri = fechaMatri;
        this.precio = precio;
        this.nomPropietario = nomPropietario;
    }     
    
    /**
     * Método get que devuelve la marca de vehículo
     * @return marca
     */
    public String getMarca() {
        return marca;
    }
    
    /**
     * Método get que devuelve la matrícula del vehículo
     * @return matricula
     */
    public String getMatricula() {
        return matricula;
    }
    
    /**
     * Método get que devuelve los kilómetros del vehículo
     * @return km
     */
    public int getKm() {
        return km;
    }
    
    /**
     * Método get que devuelve la fecha de matriculación del vehículo
     * @return fechaMatri
     */
    public String getFechaMatri() {
        return fechaMatri;
    }
    
    /**
     * Método get que devuelve el precio del vehículo
     * @return precio
     */
    public int getPrecio(){
        return precio;
    }
    
    /**
     * Método get que devuelve el nombre del propietario del vehículo
     * @return nomPropietario
     */
    public String getNomPropietario() {
        return nomPropietario;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setFechaMatri(String fechaMatri) {
        this.fechaMatri = fechaMatri;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNomPropietario(String nomPropietario) {
        this.nomPropietario = nomPropietario;
    }
  
    
      
}    
