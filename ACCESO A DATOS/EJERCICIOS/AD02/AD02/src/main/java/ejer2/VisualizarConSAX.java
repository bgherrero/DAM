
package ejer2;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 *
 * @author bgher
 */
public class VisualizarConSAX {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
        try {
            // Configura la fábrica y el parser SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            
            // Procesa el archivo con un manejador personalizado
            parser.parse(new File("libros.xml"), new XMLHandler());
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error al procesar el archivo XML: " + ex.getMessage());
        } 
    }
}

// Clase manejadora personalizada para eventos SAX
class XMLHandler extends DefaultHandler {
    private int nivel = 0;      // Para rastrear la profundidad de las etiquetas
    
    /**
     * Método invocado al abrir una etiqueta XML
     * 
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        
        // Construye la sangria en función del nivel actual
        String sangria = " ".repeat(nivel);   
        // Muestra el nombre de la etiqueta
        System.out.println(sangria + "Etiqueta: " + qName);
        
        // Imprime atributos, si los hay
        for (int i = 0; i < attributes.getLength(); i++){            
            System.out.println(" Atributo: "+attributes.getQName(i)+" - Valor: "+ attributes.getValue(i));
        }
        nivel++;    // Incrementa el nivel cada vez que empieza un elemento
    }
    /**
     * Método invocado para procesar contenido de texto dentro de etiquetas
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); 
        
        // Extrae y limpia el contenido
        String contenido = new String(ch, start, length).trim();
        
        if(!contenido.isEmpty()){
            String sangria = " ".repeat(nivel);
            System.out.println(sangria + " Valor: " + contenido);
        }
    }

    /**
     * Método invocado al cerrar una etiqueta XML
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); 
        
        nivel--;    // Baja de nivel cada vez que se termina un elemento
        
        // Imprimir una línea en blanco al cerrar un nivel principal (como <libro>)
        if(nivel == 1){
            System.out.println();
        }
    }

}
