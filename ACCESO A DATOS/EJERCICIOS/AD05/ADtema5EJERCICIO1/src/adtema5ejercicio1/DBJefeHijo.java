/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adtema5ejercicio1;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;

/**
 *
 * @author bgher
 */
public class DBJefeHijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Elimino la base de datos si ya existe para comenzar desde cero
        File fichero = new File("BDJefeHijo");
        fichero.delete();
        // Se abre la base de datos
        ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo ");

        try {
            // Almacena datos de los jefes y sus hijos
            baseDatos.store(new Jefe("Ángel", 5, 53, new Hijo("Gustavo", 7)));
            baseDatos.store(new Jefe("Nieves", 3, 45, new Hijo("Iván", 3)));
            baseDatos.store(new Jefe("Jesús", 3, 5, new Hijo("Noelia", 3)));
            baseDatos.store(new Jefe("Dolores", 5, 63, new Hijo("Sergio", 7)));
            baseDatos.store(new Jefe("Vicki", 3, 5, null));
            baseDatos.store(new Jefe("Fátima", 5, 63, new Hijo("Lidia", 27)));
            baseDatos.store(new Jefe("Juan Luís", 3, 5, null));
            baseDatos.store(new Jefe("Elena", 1, 42, new Hijo("David", 19)));
            baseDatos.store(new Jefe("Miguel", 20, 45, new Hijo("Paula", 3)));
            baseDatos.store(new Jefe("Jesús", 19, 44, new Hijo("Rubén", 12)));

            // 1. Visualizar jefes con más de 55 años
            System.out.println("------------------------------------------------");
            System.out.println("Jefes con más de 55 años:");
            ObjectSet<Jefe> resultMayor55 = baseDatos.queryByExample(Jefe.class);
            while (resultMayor55.hasNext()) {
                Jefe jefe = resultMayor55.next();
                if (jefe.getEdad() > 55) {    // Verificamos la edad
                    System.out.println(jefe);
                }
            }

            // 2. Modificar la edad de Miguel incrementándola en un año
            System.out.println("------------------------------------------------");
            Jefe jefeMiguel = new Jefe("Miguel", 0, 0, null);
            ObjectSet<Jefe> resultMiguel = baseDatos.queryByExample(jefeMiguel);
            while(resultMiguel.hasNext()){
                Jefe miguel = resultMiguel.next();
                miguel.setEdad(miguel.getEdad()+1);     // Incrementa la edad       
                baseDatos.store(miguel);                // Guarda los cambios
                System.out.println("Edad de Miguel actualizada a: "+ miguel.getEdad());
            }

            // 3. Borrar jefes con más de 6 años en la empresa
            System.out.println("------------------------------------------------");
            ObjectSet<Jefe> jefesBorrar = baseDatos.queryByExample(Jefe.class);
            while (jefesBorrar.hasNext()) {
                Jefe jefe = jefesBorrar.next();
                if (jefe.getAntiguedad() > 6) {    // Verificamos la antiguedad
                    baseDatos.delete(jefe);         // Elimina al jefe
                    System.out.println("Eliminado: "+jefe.getNombre());
                }
            }
            System.out.println("Jefes con más de 6 años en la empresa eliminados.");

            // 4. Visualizar los jefes restantes
            System.out.println("------------------------------------------------");
            System.out.println("Jefes restantes en la base de datos:");
            ObjectSet<Jefe> jefes = baseDatos.queryByExample(Jefe.class);
            while (jefes.hasNext()) {
                Jefe jefe = jefes.next();
                System.out.println(jefe);
            }
             
        } finally {
            baseDatos.close();  // Se cierra la base de datos al final
        }

    }
}
