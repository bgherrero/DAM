
package ad03;

import java.sql.*;


/**
 * 6. Modificar los vuelos de fumadores a no fumadores.
 * @author bgher
 */
public class Punto6 {

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
            
            System.out.println("\n---- MODIFICAR LOS VUELOS DE FUMADORES A NO FUMADORES ----");
            
            // Desactivar el auto-commit para permitir transacciones
            conexion.setAutoCommit(false);
            
            // Consulta para actualizar las plazas de fumador a no fumador en la tabla VUELOS
            String consultaVuelos = "UPDATE VUELOS "
                                     + "SET PLAZAS_NO_FUMADOR = PLAZAS_FUMADOR + PLAZAS_NO_FUMADOR,"
                                     + "PLAZAS_FUMADOR = 0";
            
            // Consulta para actualizar los pasajeros a "NO FUMADOR" en la tabla PASAJEROS
            String consultaPasajeros = "UPDATE PASAJEROS SET FUMADOR = 'NO'";
            
            try (Statement stmVuelos = conexion.createStatement();
                Statement stmPasajeros = conexion.createStatement()) {
                
                // Ejecuta actualización de la tabla VUELOS
                int filasVuelos = stmVuelos.executeUpdate(consultaVuelos);
                System.out.println("Vuelos actualizados: " + filasVuelos);
                
                // Ejecuta actualización de la tabla PASAJEROS
                int filasPasajeros = stmPasajeros.executeUpdate(consultaPasajeros);
                System.out.println("Pasajeros actualizados: " + filasPasajeros);
                
                // Confirmar los cambios
                conexion.commit();
                System.out.println("Cambios realizados con éxito.");
                
            }catch (SQLException ex){
                // En caso de error, deshace los cambios realizados
                System.err.println("Error durante la actualización, realizando rollback: " + ex.getMessage());
                conexion.rollback();
            }          
        } catch (SQLException ex) {
            System.err.println("Error al acceder a la base de datos: " + ex.getMessage());
        }
    }
}
