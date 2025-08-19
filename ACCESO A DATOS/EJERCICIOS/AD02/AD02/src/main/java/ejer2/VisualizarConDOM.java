
package ejer2;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author bgher
 */
public class VisualizarConDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("libros.xml");
            doc.getDocumentElement().normalize();

            // Elemento raiz
            Element root = doc.getDocumentElement();
            System.out.println("Elemento raíz: " + root.getNodeName());
            
            // Lista de elementos <libro>
            NodeList libros = doc.getElementsByTagName("libro");
            for (int i = 0; i < libros.getLength(); i++) {
                Node nodo = libros.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoLibro = (Element) nodo;

                    // Muestra el nombre del elemento <libro> y su atributo "año"
                    System.out.println("\nEtiqueta: " + elementoLibro.getNodeName());
                    System.out.println("Atributo año: " + elementoLibro.getAttribute("año"));


                    // Recorre y muestra los hijos de <libro>
                    NodeList hijosLibro = elementoLibro.getChildNodes();
                    for (int j = 0; j < hijosLibro.getLength(); j++) {
                        Node hijo = hijosLibro.item(j);

                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoHijo = (Element) hijo;
                            
                            // Evita imprimir el valor de "autor" directamente
                            if (!elementoHijo.getNodeName().equals("autor")) {
                                System.out.println("Etiqueta: " + elementoHijo.getNodeName() + " - Valor: " + elementoHijo.getTextContent());
                            } else {
                                System.out.println("Etiqueta: " + elementoHijo.getNodeName() + ":");
                            }

                            // Muestra sub-elementos (nietos), si existen
                            NodeList nietos = elementoHijo.getChildNodes();
                            for (int k = 0; k < nietos.getLength(); k++) {
                                Node nieto = nietos.item(k);

                                if (nieto.getNodeType() == Node.ELEMENT_NODE) {
                                    Element elementoNieto = (Element) nieto;
                                    System.out.println("  Sub-etiqueta: " + elementoNieto.getNodeName() + " - Valor: " + elementoNieto.getTextContent());
                                }
                            }
                        }
                    }
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            System.out.println("Error al procesar el archivo XML: " + ex.getMessage());
        }
    }
}
