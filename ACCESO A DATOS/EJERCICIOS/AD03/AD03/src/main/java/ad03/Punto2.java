/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad03;

import java.sql.*;

/**
 * 2. Mostrar la información de la tabla pasajeros.
 * @author bgher
 */
public class Punto2 {

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

            System.out.println("\n---- INFORMACIÓN DE LA TABLA PASAJEROS ----");
            
            // Consulta SQL para obtener todo los datos de la tabla PASAJEROS
            String consulta = "SELECT * FROM PASAJEROS";
            
            // Uso try-with-resource para manejar Statement y ResulSet
            try (Statement stm = conexion.createStatement(); 
                 ResultSet rs = stm.executeQuery(consulta)) {
                
                // Recorre el resultado de la consulta
                while (rs.next()) {
                    System.out.println("Número: " + rs.getInt("NUM") + " / "
                            + "Código de vuelo: " + rs.getString("COD_VUELO") + " / "
                            + "Tipo de plaza: " + rs.getString("TIPO_PLAZA") + " / "
                            + "Fumador: " + rs.getString("FUMADOR"));
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al acceder a la base de datos: " + ex.getMessage());
        }
    }
}

