
package ad03;

import java.sql.*;
import java.util.Scanner;


/**
 * 3. Ver la información de los pasajeros de un vuelo, pasando el código de vuelo como parámetro.
 * @author bgher
 */
public class Punto3 {

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

            System.out.println("\n---- INFORMACIÓN DE LA TABLA PASAJEROS DADO UN CÓDIGO ----");
            
            // Solicita el código de vuelo al usuario
            System.out.print("Introduce un código de vuelo: ");
            Scanner sc = new Scanner(System.in);
            String codVuelo = sc.nextLine();

            String consulta = "SELECT NUM, COD_VUELO, TIPO_PLAZA, FUMADOR FROM PASAJEROS WHERE COD_VUELO =?";
            
            // Uso de PreparedStatement para la consulta
            try (PreparedStatement pstm = conexion.prepareStatement(consulta)) {
                pstm.setString(1, codVuelo);
                
                // Ejecuta la consulta y procesa los resultados
                try (ResultSet rs = pstm.executeQuery()) {

                    // Verifica si no hay resultados
                    if (!rs.isBeforeFirst()) {
                        System.out.println("No hay pasajeros registrados en este vuelo");
                    } else {
                        // Itinera sobre los resultados
                        while (rs.next()) {
                            System.out.println("Número: " + rs.getInt("NUM") + " / "
                                    + "Código de vuelo: " + rs.getString("COD_VUELO") + " / "
                                    + "Tipo de plaza: " + rs.getString("TIPO_PLAZA") + " / "
                                    + "Fumador: " + rs.getString("FUMADOR"));
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al acceder a la base de datos: " + ex.getMessage());
        }
    }
}
