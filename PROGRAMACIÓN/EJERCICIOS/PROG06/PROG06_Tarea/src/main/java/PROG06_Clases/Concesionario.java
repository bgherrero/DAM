/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG06_Clases;

/**
 *
 * @author bgher
 */
public class Concesionario {
    
    private Vehiculo[] concesionario;
    private int contador;
    
    public Concesionario(){
        this.contador = 0;
        this.concesionario = new Vehiculo [50];
    }
    /**
     * Dada una matrícula, busca si ese vehículo está en el Concesioanrio
     * @param matricula del vehículo que queremos buscar
     * @return los datos de vehículo si éste existe, o null si no existe
     */
    public Vehiculo buscaVehiculo(String matricula){
        
        for(int i=0; i<contador; i++){
            Vehiculo v = concesionario[i];
                        
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
     *          -1 si el concesionario está lleno
     *          -2 si la matrícula ya exite
     * 
     */
    public int insertarVehiculo(Vehiculo v){
        
        if(contador == concesionario.length){
            return -1;
        }
        
        if (!(buscaVehiculo(v.getMatricula())== null)){            
            return -2;
        }else{
            concesionario[contador] = v;
            contador++;
            return 0;
        }
        
    }
    /**
     * Lista por pantalla los datos de todos los vehículos del concesionario
     */
    public void listaVehiculos(){
        
        for(int i=0; i<contador; i++){
            Vehiculo v = concesionario[i];
            System.out.println( "Vehículo número "+ contador);
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
}
