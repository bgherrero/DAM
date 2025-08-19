
package ad03;

import java.sql.*;
import java.util.Scanner;

/**
 * 5. Borrar el vuelo que se metió anteriormente en el que se pasa por parámetro su número de vuelo.
 * @author bgher
 */
public class Punto5 {

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
            System.out.println("\n---- ELIMINAR UN VUELO ----");

            // Solicita al usuario el código del vuelo a eliminar 
            System.out.print("Introduce un código de vuelo: ");
            String codVuelo = sc.nextLine();

            // Consulta para eliminar el vuelo
            String consulta = "DELETE FROM VUELOS WHERE COD_VUELO =?";
            try (PreparedStatement pstm = conexion.prepareStatement(consulta)) {
                pstm.setString(1, codVuelo);

                // Ejecuta la eliminación
                int filas = pstm.executeUpdate();
                if (filas > 0) {
                    System.out.println("Vuelo eliminado");
                }else{
                    System.out.println("No se pudo eliminar el vuelo. Verificar si el código es correcto.");
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al acceder a la base de datos: " + ex.getMessage());
        }
    }
}
