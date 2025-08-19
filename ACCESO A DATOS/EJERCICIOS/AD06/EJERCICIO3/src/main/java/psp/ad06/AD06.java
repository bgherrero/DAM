

package psp.ad06;

/**
 *
 * @author bgher
 */

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XPathQueryService;

public class AD06 {
    private static final String URI = "xmldb:exist://localhost:8080/exist/xmlrpc"; // URL de la base de datos
    private static final String COLLECTION_PATH = "/db/libros"; // Ruta de la colección
    private static final String USERNAME = "admin"; // Usuario de eXist
    private static final String PASSWORD = "admin"; // Contraseña de eXist

    public static void main(String[] args) {
        try {
            // Cargar el driver de la base de datos eXist
            String driver = "org.exist.xmldb.DatabaseImpl";
            Class<?> cl = Class.forName(driver);
            Database database = (Database) cl.getDeclaredConstructor().newInstance();
            DatabaseManager.registerDatabase(database);

            // Conectar a la colección
            Collection collection = (Collection) DatabaseManager.getCollection(URI + COLLECTION_PATH, USERNAME, PASSWORD);
            if (collection == null) {
                System.out.println("No se pudo acceder a la colección: " + COLLECTION_PATH);
                return;
            }

            // Crear un servicio de consulta XPath
            XPathQueryService queryService = (XPathQueryService) collection.getService("XPathQueryService", "1.0");

            // Consulta para obtener los títulos de los libros
            String xQuery = "/bib/libro/titulo";
            ResourceSet resultSet = queryService.query(xQuery);

            // Mostrar los resultados
            ResourceIterator iterator = resultSet.getIterator();
            System.out.println("Listado de libros en la base de datos:");
            while (iterator.hasMoreResources()) {
                Resource resource = iterator.nextResource();
                System.out.println(resource.getContent());
            }

            // Cerrar la colección
            collection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

