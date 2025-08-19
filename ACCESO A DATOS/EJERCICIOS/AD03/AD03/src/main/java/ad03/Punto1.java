
package ad03;

import java.sql.*;
import java.util.Scanner;


/**
 * 1. Mostrar y pedir información de la base de datos en general
 * @author bgher
 */
public class Punto1 {

    public static void main(String[] args) {
        // URL de conexión y credenciales de la base de datos
        String urljdbc = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "aerolinea";
        String contraseña = "aerolinea";

        // Uso try-with-resource para garantizar el cierre de la conexión
        try (Connection conexion = DriverManager.getConnection(urljdbc, usuario, contraseña)) {
            // Conexión exitosa
            System.out.println("---- INFORMACIÓN GENERAL DE LAS TABLAS ----");
            
            // Consulta para obtener los nombres de las tablas
            String consultaTablas = "SELECT table_name FROM user_tables";

            try (Statement stmTablas = conexion.createStatement()) {
                ResultSet rsTablas = stmTablas.executeQuery(consultaTablas);
                
                // Itera sobre las tablas encontradas
                while (rsTablas.next()) {
                    // Muestra los nombres de las tablas
                    String nombreTabla = rsTablas.getString("table_name");
                    System.out.println("Nombre de la tabla: " + nombreTabla);

                    // Consulta para obtener los nombres de las columnas de la tabla actual
                    String consultaColumnas = "SELECT column_name "
                                            + "FROM user_tab_columns "
                                            + "WHERE table_name = ?";
                    try (PreparedStatement stmColumnas = conexion.prepareStatement(consultaColumnas)) {
                        stmColumnas.setString(1, nombreTabla);
                        try (ResultSet rsColumnas = stmColumnas.executeQuery()) {
                            while (rsColumnas.next()) {
                                System.out.println(" - Columna: " + rsColumnas.getString("column_name"));
                            }
                        }
                    }
                }
            }

        } catch (SQLException ex) {
            System.err.println("Error al acceder a la base de datos: " + ex.getMessage());
        }

        }
    }
