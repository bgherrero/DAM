

package prog09_tarea;

import prog09_clases.*;
import prog09_util.Validar;
import java.util.Scanner;

/**
 *
 * @author bgher
 */
public class PROG09_Tarea {

    public static void main(String[] args) {
        
        // Inicializamos todas las variables
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        // Variables para Persona
        String nombre, apellidos, DNI;
        Persona titular;
        // Variables para las distintas Cuentas Bancarias
        String iban, entidadesAutorizadas;
        double saldo,interesAnual,comisionMantenimiento, maxDescubierto, comisionDescubierto, interesDescubierto;
        CuentaBancaria cuenta = null;
        // En el banco almacenaremos las distintas Cuentas Bancarias
        Banco banco = new Banco();
        banco.recuperarInfo();
        
        while( salir != true){      // Hasta que no elijamos salir, el bucle seguirá funcionando
            
            System.out.println("Elige una opción:\n"
                    + "1.Abrir una nueva cuenta.\n"
                    + "2.Ver un listado de las cuentas disponibles.\n"
                    + "3.Obtener los datos de una cuenta. Realizar un ingreso en una cuenta.\n"
                    + "4.Retirar efectivo de una cuenta.\n"
                    + "5.Consultar el saldo actual de una cuenta.\n"
                    + "6.Eliminar cuenta.\n"
                    + "7.Listado clientes.\n"
                    + "8.Salir de la aplicación.\n");
            
            int menu = teclado.nextInt();
            teclado.nextLine();
            
            switch (menu){
                // Abrir una nueva cuenta. Se solicitan todos los datos por pantalla y se crea la nueva cuenta
                case 1:                 
                    System.out.println("Nombre del titular de la cuenta: ");
                    nombre = teclado.nextLine();
                    System.out.println("Apellidos del titular de la cuenta: ");
                    apellidos = teclado.nextLine();
                                       
                    do{     // hasta que no se introduzca un DNI con el formato correcto no continua el programa 
                        System.out.println("Introduzca el DNI del propietario: ");
                        DNI = teclado.next();
                        
                        if(!Validar.dniCorrecto(DNI)){
                            System.out.println("Formato de DNI incorrecto.");
                        }
                    }while (!Validar.dniCorrecto(DNI));
                    
                    titular = new Persona(nombre, apellidos, DNI);
                    
                    do{     // hasta que no se introduzca un IBAN con el formato correcto no continua el programa
                        System.out.println("IBAN de la cuenta: ");
                        iban = teclado.next();
                        
                        if(!Validar.ibanCorrecto(iban)){
                            System.out.println("Formato de IBAN incorrecto. Ha de ser: ESNNNNNNNNNNNNNNNNNNNN");
                        }
                    }while (!Validar.ibanCorrecto(iban));
                                        
                    System.out.println("Saldo inicial de la cuenta: ");
                    saldo = teclado.nextDouble();
                                        
                    // Para elegir el tipo de cuenta bancaria
                    System.out.println("Seleccione que tipo de cuenta desea abrir:\n"
                            + "1.Cuenta de ahorro.\n"
                            + "2.Cuenta corriente personal.\n"
                            + "3.Cuenta corriente de empresa.\n");
                    int tipoCuenta = teclado.nextInt();
                    teclado.nextLine(); 
                    
                    switch(tipoCuenta){
                        case 1:
                            System.out.println("El interés anual de la cuenta: ");
                            interesAnual = teclado.nextDouble();

                            cuenta = new CuentaAhorro(titular, saldo, iban, interesAnual);
                            break;
                            
                        case 2:
                            System.out.println("Entidades autorizadas: ");
                            entidadesAutorizadas = teclado.nextLine();
                            System.out.println("La comisión de mantenimiento de la cuenta: ");
                            comisionMantenimiento = teclado.nextDouble();

                            cuenta = new CuentaCorrientePersonal(titular, saldo, iban, entidadesAutorizadas, comisionMantenimiento);
                            break;
                            
                        case 3:
                            System.out.println("Entidades autorizadas: ");
                            entidadesAutorizadas = teclado.nextLine();
                            System.out.println("El máximo descubierto permitido de la cuenta: ");
                            maxDescubierto = teclado.nextDouble();
                            System.out.println("El tipo de interés por descubierto de la cuenta: ");
                            interesDescubierto = teclado.nextDouble();
                            System.out.println("La comisión fija por cada descubierto de la cuenta: ");
                            comisionDescubierto = teclado.nextDouble();

                            cuenta = new CuentaCorrienteEmpresa(titular, saldo, iban, entidadesAutorizadas, 
                                                            maxDescubierto, interesDescubierto, comisionDescubierto);
                            break;
                    }
                    
                    if (banco.abrirCuenta(cuenta)){
                        System.out.println("Cuenta abierta correctamente.");
                    }else{
                        System.out.println("No ha sido posible abrir la cuenta.");
                    }
                    break;
                    
                // Ver un listado de las cuentas disponibles    
                case 2:             
                    String[]infoCuentas = banco.listadoCuentas();
                    for(String c: infoCuentas){
                        System.out.println(c);
                    }
                    break;
                    
                // Obtener los datos de una cuenta. Realizar un ingreso en una cuenta.    
                case 3:   
                    System.out.println("Introduzca IBAN de la cuenta:");
                    iban = teclado.next();
                    
                    if(banco.informacionCuenta(iban)!= null){
                        System.out.println(banco.informacionCuenta(iban));  
                    }else{
                        System.out.println("Esa cuenta no existe.");
                    }
                    
                    System.out.println("Introduzca IBAN de la cuenta:");
                    iban = teclado.next();
                    System.out.println("Introduzca la cantidad a ingresar:");
                    double ingreso = teclado.nextDouble();
                    if(banco.ingresoCuenta(iban, ingreso)){
                        System.out.println("Se ha ingresado "+ ingreso +" correctamente.");
                    }else{
                        System.out.println("Ingreso no realizado.");
                    }
                    
                    break;
                    
                // Retirar efectivo de una cuenta    
                case 4:    
                    System.out.println("Introduzca IBAN de la cuenta:");
                    iban = teclado.next();
                    System.out.println("Introduzca la cantidad a retirar:");
                    double retirada = teclado.nextDouble();
                    if(banco.retiradaCuenta(iban, retirada)){
                        System.out.println("Se ha retirado "+ retirada +" correctamente.");
                    }else{
                        System.out.println("Retirada no realizada.");
                    }
                    break;
                    
                // Consultar el saldo actual de una cuenta    
                case 5:  
                    System.out.println("Introduzca IBAN de la cuenta:");
                    iban = teclado.next();
                    if ( banco.obtenerSaldo(iban) == -1){
                        System.out.println("Esa cuenta no existe.");
                    }else{
                        System.out.println("Saldo= " + banco.obtenerSaldo(iban));
                    }                    
                    break;
                    
                // Eliminar una cuenta
                case 6:
                    System.out.println("Introduzca IBAN de la cuenta a eliminar:");
                    iban = teclado.next();
                    if(banco.eliminarCuenta(iban)){
                        System.out.println("Cuenta eliminada.");
                    }else{
                        System.out.println("No ha sido posible eliminar esa cuenta.");
                    }
                    break;
                    
                 // Listado clientes. Crea un archivo con el titular y el iban de la cuenta bancaria    
                case 7: 
                    if( banco.listarClientes()){
                        System.out.println("Listado realizado correctamente.");
                    }else{
                        System.out.println("Error al realizar el Listado de Clientes.");
                    }
                    
                    break;
                    
                // Salir de la aplicación    
                case 8: 
                    
                    banco.guardarInfo();
                    System.out.println("Cuentas guardadas");
                    salir = true;
                    break;
            }          
        }
        
    }
}
