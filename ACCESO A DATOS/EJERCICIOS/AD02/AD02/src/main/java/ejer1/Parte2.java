
package ejer1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author bgher
 */
public class Parte2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            RandomAccessFile raf = new RandomAccessFile("EMPLEADOS.DAT", "r");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            
            // Crea documento con el elemento raíz <empleado>
            Document doc = implementation.createDocument(null, "empleados", null);
            Element rootElement = doc.getDocumentElement();
            
            // Lee cada empleado desde el archivo binario
            while(raf.getFilePointer() < raf.length()){
                
                int codigo = raf.readInt();
                
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 30; i++){
                    sb.append(raf.readChar());
                }
                String nombre = sb.toString();
                
                sb = new StringBuilder();
                for (int i = 0; i < 50; i++){
                    sb.append(raf.readChar());
                }
                String direccion = sb.toString();
                
                float salario = raf.readFloat();
                float comision = raf.readFloat();
            
            
            // Crea elemento <empleado> y añadirlo al elemento raiz
            Element empleadoElement = doc.createElement("empleado");
            rootElement.appendChild(empleadoElement);
            
            // Elemento <codigo>
            Element codigoElement = doc.createElement("codigo");
            Text textCodigo = doc.createTextNode(Integer.toString(codigo));
            codigoElement.appendChild(textCodigo);          // Añade el nodo del texto del código
            empleadoElement.appendChild(codigoElement);     // Añade <codigo> dentro del empleado
            
            // Elemento <nombre>
            Element nombreElement = doc.createElement("nombre");
            Text textNombre = doc.createTextNode(nombre.trim());
            nombreElement.appendChild(textNombre);
            empleadoElement.appendChild(nombreElement);
            
            // Elemento <direccion>
            Element direccionElement = doc.createElement("direccion");
            Text textDireccion = doc.createTextNode(direccion.trim());
            direccionElement.appendChild(textDireccion);
            empleadoElement.appendChild(direccionElement);
            
            // Elemento <salario>
            Element salarioElement = doc.createElement("salario");
            Text textSalario = doc.createTextNode(Float.toString(salario));
            salarioElement.appendChild(textSalario);
            empleadoElement.appendChild(salarioElement);
            
            // Elemento <comision>
            Element comisionElement = doc.createElement("salario");
            Text textComision = doc.createTextNode(Float.toString(comision));
            comisionElement.appendChild(textComision);
            empleadoElement.appendChild(comisionElement);            
            }
            
            // Guarda el documento XML en un archivo
            Source source = new DOMSource(doc);
            Result result = new StreamResult(new File ("EMPLEADOS.XML"));
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
            System.out.println("Archivo EMPLEADOS.XML creado correctamente.");
            
            
        } catch (IOException | ParserConfigurationException | TransformerException ex) {
            System.err.println("Error al crear el archivo XML: " + ex.getMessage());
        }  
    }
    
}
