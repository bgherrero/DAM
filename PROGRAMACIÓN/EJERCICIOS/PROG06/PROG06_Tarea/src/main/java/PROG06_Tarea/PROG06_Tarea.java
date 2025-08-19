

package PROG06_Tarea;

import PROG06_Util.Validar;
import PROG06_Clases.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Aplicación capaz de gestionar un concesionario, que almacena los datos de distintos 
 * @author bgher
 */
public class PROG06_Tarea {

    public static void main(String[] args) {
        
        int menu;
        boolean salir = false;      // Para poder salir del menu
        boolean valido = false;     // Para hacer comprobaciones
        Scanner teclado = new Scanner(System.in);
        
        // Inicializamos un concesionario donde se van a almacenar los vehículos
        Concesionario concesionario = new Concesionario();
        
        // Inicializamos un vehículo y sus atributos
        Vehiculo coche = null;      
        String marca;
        String matricula;
        int km = 0;
        int anioMatri=0, mesMatri=0, diaMatri = 0;
        String descripcion;
        int precio = 0;
        String nomPropietario;
        String dniPropietario;
        
        while(!salir){      // Menú que aparece por la pantalla
            System.out.println("""
                           Selecciona una opcion:
                           1.Nuevo Vehículo
                           2.Listar Vehículos
                           3.Buscar Vehículo
                           4.Modificar kms Vehículo
                           5.Salir
                           """);
            menu = teclado.nextInt();
            teclado.nextLine();
                
            switch (menu){
                case 1:     // Nuevo Vehículo
                    System.out.println("Introduzca la marca: ");
                    marca = teclado.nextLine();
                    
                    // Introducir y validar la matrícula
                    do {
                        System.out.println("Introduzca la matricula: ");
                        matricula = teclado.nextLine();
                    
                        if(!Validar.matriculaCorrecta(matricula)){
                            System.out.println("""
                                           Formato de matr\u00edcula incorrecta.
                                           Ha de ser NNNNLLL, donde N son n\u00fameros y L letras""");
                        }
                    }while(!Validar.matriculaCorrecta(matricula));
                    
                    // Introducir y validar los kilómetros
                    do {
                        valido = true;
                        try{
                            System.out.println("Introduzca los kilómetros: ");
                            km = teclado.nextInt();
                            teclado.nextLine();
                            
                            if(km<0){
                                System.out.println("Los kilómetros han de ser positivos.");
                                valido = false;
                            }
                        }catch(InputMismatchException e){
                            System.out.println("Número de kilómetors erróneos");
                            valido = false;
                            teclado.nextLine();
                        }
                    }while(!valido);
                    
                    // Introducir y validar la fecha
                    do{
                        valido = true;
                        
                        try{
                            System.out.println("Introduzca el año de la matriculación: ");
                            anioMatri = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println("Introduzca el mes de la matriculación: ");
                            mesMatri = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println("Introduzca el dia de la matriculación: ");
                            diaMatri = teclado.nextInt();
                            teclado.nextLine();
                            LocalDate fechaMatriculacion = LocalDate.of(anioMatri, mesMatri, diaMatri);                       
                                                       
                        }catch(InputMismatchException e){
                            System.out.println("Dato incorrecto");
                            valido = false;
                            teclado.nextLine();
                        }catch(DateTimeException e){
                            System.out.println("Dato incorrecto");
                            valido = false;
                               
                        }
                    }while(!valido);                    
                    
                    // Introducir la descripción
                    System.out.println("Introduzca una pequeña descripcion: ");
                    descripcion = teclado.nextLine();
                    
                    // Introducir y validar el precio
                    do {
                        valido = true;
                        try{
                            System.out.println("Introduzca el precio: ");
                            precio = teclado.nextInt();
                            teclado.nextLine();
                            
                        }catch(InputMismatchException e){
                            System.out.println("Precio del vehículo erróneo");
                            valido = false;
                            teclado.nextLine();
                        }
                    }while(!valido);
                    
                    // Introducir y validar el nombre del propietario
                    do{
                        System.out.println("Introduzca el nombre del propietario: ");
                        nomPropietario = teclado.nextLine();
                        
                        if(!Validar.nombreCorrecto(nomPropietario)){
                            System.out.println("El nombre del propietario ha de contener el nombre y dos apellidos");
                        }
                    }while(!Validar.nombreCorrecto(nomPropietario));
                    
                    // Introducir y validar el DNI
                    do{
                        System.out.println("Introduzca el DNI del propietario: ");
                        dniPropietario = teclado.nextLine();
                        
                        if(!Validar.dniCorrecto(dniPropietario)){
                            System.out.println("Formato de DNI incorrecto");
                        }
                    }while (!Validar.dniCorrecto(dniPropietario));
                    
                    // Se crea el vehiculo nuevo y se intenta insertar en el concesionario
                    coche = new Vehiculo( marca, matricula, km, anioMatri, mesMatri, diaMatri, 
                                descripcion, precio, nomPropietario, dniPropietario);
                    
                    switch (concesionario.insertarVehiculo(coche)) {
                        case -11: 
                            System.out.println("El concesionario está lleno.");
                            break;
                        case -2:
                            System.out.println("El vehiculo introducido ya existe.");
                            break;
                        case 0:
                            concesionario.insertarVehiculo(coche);
                            System.out.println("El vehiculo insertado correctamente.");
                            break;
                    }
                    
                    break;


                    
                case 2:     // Listar Vehículo
                    concesionario.listaVehiculos();
                    break;
                    
                case 3:     // Buscar Vehículo
                    System.out.println("Introduzca la matrícula del vehículo que quiere buscar: ");
                    matricula = teclado.nextLine();
                    
                    coche = concesionario.buscaVehiculo(matricula);
                    
                    if(coche == null){
                        System.out.println("No existe vehículo con la matrícula introducida");
                    }else{                        
                        System.out.printf("""
                                          Las características de vehículo son:
                                          marca: %s 
                                          matrícula: %s
                                          precio: %s
                                          """, 
                                coche.getMarca(), coche.getMatricula(),coche.getPrecio());                                
                    }        
                    break;
                    
                case 4:     // Modificar Kms
                    System.out.println("Introduzca la matrícula del vehículo: ");
                    matricula = teclado.nextLine();
                    do{
                        valido = true;
                        try{
                            System.out.println("Introduzca los nuevos km del vehículo: ");
                            km = teclado.nextInt();
                            teclado.nextLine();
                        }catch(InputMismatchException e){
                            System.out.println("Número de kilómetors erróneos");
                            valido = false;
                            teclado.nextLine();
                        }
                    }while(!valido);
                    
                                     
                    if(concesionario.actualizaKms(matricula, km)){
                        System.out.println("Kilómetros actualizados correctamente");
                    }else{                        
                        System.out.println("No existe vehículo con la matrícula introducida");                                
                    }
                    break;

                case 5:     // Salir
                    salir = true;
                    break;
            }    
        }
    }
}
