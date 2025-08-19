
package PROG08_Clases;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author bgher
 */
public class Concesionario {
    /** Elijo LinkedList para almacenar los vehículos porque es más apropiado en el caso
    * de realizar muchas inserciones y eliminaciones de vehículos, 
    * que supongo que es lo que pasará
    */
    private LinkedList <Vehiculo> concesionario;
        
    public Concesionario(){
        
        this.concesionario = new LinkedList<>();
    }
    /**
     * Dada una matrícula, busca si ese vehículo está en el Concesioanrio
     * @param matricula del vehículo que queremos buscar
     * @return los datos de vehículo si éste existe, o null si no existe
     */
    public Vehiculo buscaVehiculo(String matricula){
        
        for(Vehiculo v: this.concesionario){
            if(v.getMatricula().equalsIgnoreCase(matricula)){
                return v;
            }
        } 
        return null;
    }
    /**
     * Recibe los datos de un vehíuclo y trata de insertarlos en el concesionario
     * @param v son los datos del vehículo
     * @return   0 si se realiza con éxito
     *           -2 si la matrícula ya exite
     * 
     */
    public int insertarVehiculo(Vehiculo v){
                
        if (!(buscaVehiculo(v.getMatricula())== null)){            
            return -2;
        }else{
            this.concesionario.add(v);
            Collections.sort(concesionario);
            return 0;
        }
        
    }
    /**
     * Lista por pantalla los datos de todos los vehículos del concesionario
     */
    public void listaVehiculos(){
        
        for(Vehiculo v : concesionario){
            
            System.out.println( "Vehículo número "+ concesionario.size());
            System.out.println("Marca: "+v.getMarca());
            System.out.println("Matrícula: "+v.getMatricula());
            System.out.println("Kilómetros: "+v.getKm());
            System.out.println("Fecha de matriculación: "+v.getFechaMatri());
            System.out.println("Descripción: "+v.getDescripcion());
            System.out.println("Precio: "+v.getPrecio());
            System.out.println("Nombre del propietario: "+v.getNomPropietario());
            System.out.println("DNI del propietario: "+v.getDniPropietario());
            System.out.println();
        }     
    }
    /**
     * Actualiza los km de un vehículo dada una matricula
     * @param matricula del coche a modificar los km
     * @param km kilómetro nuevos del vehículo
     * @return  true si se realiza la actualización
     *          false si no se realiza
     */
    public boolean actualizaKms(String matricula,int km){
                                
        if(buscaVehiculo(matricula) == null){                 
            return false;
        }else{
            buscaVehiculo(matricula).setKm(km); 
            return true;
        }         
    }
    /**
     * Elimina un vehículo dada una matrícula
     * @param matricula
     * @return true si se hace correctamente
     */
    public boolean eliminarVehiculo(String matricula){
        Vehiculo v = buscaVehiculo(matricula);
        if(v == null){
            return false;
        }else{
            this.concesionario.remove(v);
            return true;
        }
    }
}
