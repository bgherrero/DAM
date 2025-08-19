
package PROG05_Ejerc1;


import PROG05_Ejerc1_util.Validar;
import java.util.Scanner;


/**
 * Aplicación para gestionar un vehículo
 * @author bgher
 */
public class PROG05_Ejerc1 {

    public static void main(String[] args) {
        
        int menu;
        boolean salir = false;      // Para poder salir del menu
        Vehiculo coche = null;      // Inicializamos un vehículo
        Scanner teclado = new Scanner(System.in);
        
        
        while(!salir){              // Hasta que no elijamos 9.Salir, el bucle sigue funcionando
            System.out.println("""
                                Elige una opci\u00f3n: 
                                1. Nuevo Veh\u00edculo
                                2. Ver Matr\u00edcula
                                3. Ver n\u00famero de Kil\u00f3metros
                                4. Actualizar Kil\u00f3metros
                                5. Ver a\u00f1os de antig\u00fcedad
                                6. Mostrar propietario
                                7. Mostrar descripci\u00f3n
                                8. Mostrar Precio
                                9. Salir""");
            menu = teclado.nextInt();
            teclado.nextLine();

            
            switch (menu){
                case 1:             // Insertar un vehículo. Introducimos todos los datos
                    System.out.println("Introduzca la marca: ");
                    String marca = teclado.nextLine();

                    System.out.println("Introduzca la matricula: ");
                    String matricula = teclado.nextLine();

                    System.out.println("Introduzca los kilómetros: ");
                    int km = teclado.nextInt();
                    teclado.nextLine();
                    // Comprueba si los km introducidos son > 0
                    if (!Validar.kmCorrecto(km)){        
                        System.out.println("Kilómetros no correctos.");
                        break;
                    }
                    
                    System.out.println("Introduzca el año de la matriculación: ");
                    int anioMatri = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Introduzca el mes de la matriculación: ");
                    int mesMatri = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Introduzca el dia de la matriculación: ");
                    int diaMatri = teclado.nextInt();
                    teclado.nextLine();
                    // Comprueba si la fecha introducida es anterior a la fecha actual
                    if(!Validar.fechaCorrecta(anioMatri,mesMatri,diaMatri)){
                        System.out.println("Fecha no correcta.");
                        break;
                    }

                    System.out.println("Introduzca una pequeña descripcion: ");
                        String descripcion = teclado.nextLine();

                    System.out.println("Introduzca el precio: ");
                    int precio = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Introduzca el nombre del propietario: ");
                    String nomPropietario = teclado.nextLine();

                    System.out.println("Introduzca el DNI del propietario: ");
                    String dniPropietario = teclado.nextLine();
                    // Comprueba si el DNI es válido
                    try{
                        if(!Validar.dniCorrecto(dniPropietario)){
                            throw new Exception("DNI no correcto.");
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    

                    coche = new Vehiculo( marca, matricula, km, anioMatri, mesMatri, diaMatri, 
                                descripcion, precio, nomPropietario, dniPropietario);

                    break;

                case 2:             // Ver matrícula
                    if (Vehiculo.getContador() == 0){
                        System.out.println("No se ha registrado ningún vehículo.");
                    }else{
                        System.out.println("La matrícula del vehículo es "+ coche.getMatricula());
                    }
                    break;

                case 3:             // Ver número de kilómetros
                    if (Vehiculo.getContador() == 0){
                        System.out.println("No se ha registrado ningún vehículo.");
                    }else{
                        System.out.println("El vehiculo tiene "+ coche.getKm() + " km.");
                    }
                    break;

                case 4:             // Actualiza los km, solo se puede aumentar
                    if (Vehiculo.getContador() == 0){
                        System.out.println("No se ha registrado ningún vehículo.");
                    }else{
                        System.out.println("Introduzca el nuevo número de kilómetros: ");
                        int nuevoKm = teclado.nextInt();
                        if ( nuevoKm > coche.getKm()){
                            coche.setKm(nuevoKm);   
                            System.out.println("Kilómetros actualizados.");
                        }else{
                            System.out.println("Kilómetros no correctos.");
                        }
                    }
                    break;

                case 5:             // Muestra los años de antigüedad del vehículo
                    if (Vehiculo.getContador() == 0){
                        System.out.println("No se ha registrado ningún vehículo");
                    }else{
                        System.out.println("El vehículo tiene " + coche.get_Anios() + " años.");
                    }
                    break;

                case 6:             // Muestra el nombre y el dni del propietario
                    if (Vehiculo.getContador() == 0){
                        System.out.println("No se ha registrado ningún vehículo");
                    }else{
                        System.out.println("El propietario del vehículo es "+ coche.getNomPropietario() + 
                                " y su DNI es " + coche.getDniPropietario());
                    }
                    break;

                case 7:             // Muestra la descripción, la matrícula y los km del vehículo
                    if (Vehiculo.getContador() == 0){
                        System.out.println("No se ha registrado ningún vehículo");
                    }else{
                        System.out.println("La descripción del vehículo es "+ coche.getDescripcion() + ".\n" + 
                                "Su matrícula es " + coche.getMatricula() + ".\n" +
                                "Tiene " + coche.getKm() + " km.");
                    }
                    break;

                case 8:             // Muestra el precio
                    if (Vehiculo.getContador() == 0){
                        System.out.println("No se ha registrado ningún vehículo");
                    }else{
                        System.out.println("El precio del vehículo es "+ coche.getPrecio() + " euros");
                    }
                    break;

                case 9:             // Salir del bucle (menu)
                    salir = true;
                    break;
            }
            
        }
    }
}


