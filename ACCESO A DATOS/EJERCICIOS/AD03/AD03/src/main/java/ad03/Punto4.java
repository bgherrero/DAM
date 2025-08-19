
package ad03;

import java.sql.*;
import java.util.Scanner;

/**
 * 4. Insertar un vuelo cuyos valores se pasan como parámetros
 * @author bgher
 */
public class Punto4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // URL de conexión y credenciales de la base de datos
        String urljdbc = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "aerolinea";
        String contraseña = "aerolinea";

        // Uso try-with-resource para garantizar el cierre de la conexión
        try (Connection conexion = DriverManager.getConnection(urljdbc, usuario, contraseña)) {

            Scanner sc = new Scanner(System.in);
            System.out.println("\n---- INSERTAR UN VUELO ----");
            
            // Solicita los datos del vuelo al usuario
            System.out.print("Introduce un código de vuelo: ");
            String codVuelo = sc.nextLine();

            System.out.print("Introduce la hora de salida: ");
            String horaSalida = sc.nextLine();

            System.out.print("Introduce el destino: ");
            String destino = sc.nextLine();

            System.out.print("Introduce la procedencia: ");
            String procedencia = sc.nextLine();

            System.out.print("Introduce el número de plazas de fumador: ");
            int plazasFumador = sc.nextInt();

            System.out.print("Introduce el número de plazas de no fumador: ");
            int plazasNoFumador = sc.nextInt();

            System.out.print("Introduce el número de plazas de turista: ");
            int plazasTurista = sc.nextInt();

            System.out.print("Introduce el número de plazas de primera: ");
            int plazasPrimera = sc.nextInt();

            // Consulta SQL para insertar un vuelo
            String consulta = "INSERT INTO VUELOS VALUES (?,?,?,?,?,?,?,?)";

            // Uso de PreparedStatement para la consulta
            try (PreparedStatement pstm = conexion.prepareStatement(consulta)) {
                
                // Asigna los valores a los parámetros de la consulta
                pstm.setString(1, codVuelo);
                pstm.setString(2, horaSalida);
                pstm.setString(3, destino);
                pstm.setString(4, procedencia);
                pstm.setInt(5, plazasFumador);
                pstm.setInt(6, plazasNoFumador);
                pstm.setInt(7, plazasTurista);
                pstm.setInt(8, plazasPrimera);

                // Ejecuta la consulta y verifica el resultado
                int filas = pstm.executeUpdate();

                if (filas > 0) {
                    System.out.println("Vuelo insertado correctamente.");
                } else {
                    System.out.println("No pudo insertarse el vuelo.");
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al acceder a la base de datos: " + ex.getMessage());
        }
    }

}
