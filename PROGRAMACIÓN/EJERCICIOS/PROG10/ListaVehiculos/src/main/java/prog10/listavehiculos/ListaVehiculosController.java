
package prog10.listavehiculos;

import Vehiculo.Vehiculo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;



/**
 * FXML Controller class
 *
 * @author bgher
 */
public class ListaVehiculosController implements Initializable {

    // Declaración de la talba y las columnas
    @FXML
    private TableView<Vehiculo> tablaVehiculos;
    @FXML    
    private TableColumn<Vehiculo, String> matriculaCL;
    @FXML
    private TableColumn<Vehiculo, String> marcaCL;
    @FXML
    private TableColumn<Vehiculo, Integer> kmCL;
    @FXML
    private TableColumn<Vehiculo, String> fechaMatriCL;
    @FXML
    private TableColumn<Vehiculo, Integer> precioCL;
    @FXML
    private TableColumn<Vehiculo, String> propietarioCL;
    @FXML
    private TableColumn<Vehiculo, String> eliminarCL;
    private Button eliminarBT;
   
        
    // Declaración de los TextFields
    @FXML
    private TextField matriculaTF;
    @FXML
    private TextField marcaTF;
    @FXML
    private TextField kmTF;
    @FXML
    private TextField fechaMatriTF;
    @FXML
    private TextField precioTF;
    @FXML
    private TextField propietarioTF;
       
    // Declaración de los botones
    @FXML
    private Button aniadirBT;
    
        
    private ObservableList<Vehiculo> vehiculos= FXCollections.observableArrayList();  // Aqui se va almacenando todos los vehiculos que vamos añadiendo
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        matriculaCL.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        marcaCL.setCellValueFactory(new PropertyValueFactory<>("marca"));
        kmCL.setCellValueFactory(new PropertyValueFactory<>("km"));
        fechaMatriCL.setCellValueFactory(new PropertyValueFactory<>("fechaMatri"));
        precioCL.setCellValueFactory(new PropertyValueFactory<>("precio"));
        propietarioCL.setCellValueFactory(new PropertyValueFactory<>("nomPropietario"));
        eliminarCL.setCellValueFactory(new PropertyValueFactory<>("eliminarBT"));
        
        // Nos permite crear un botón en cada nueva fila que se crea, y si pulsamos en él se elimina esa fila
        Callback<TableColumn<Vehiculo, String>, TableCell<Vehiculo,String>> constuirEliminarCL = (param)-> {      
            final TableCell<Vehiculo, String> celda = new TableCell<Vehiculo, String>(){

                @Override
                public void updateItem(String item, boolean empty){
                    if(empty){
                        setGraphic(null);
                        setText(null);
                    }else {
                        eliminarBT = crearBoton("Eliminar vehiculo.");
                        eliminarBT.setOnAction((event) -> {
                            Vehiculo vehiculo = getTableView().getItems().get(getIndex());
                            tablaVehiculos.getItems().remove(vehiculo);
                        });
                        setGraphic(eliminarBT);
                        setText(null);
                    }
                }
            };
            return celda;            
        };
        eliminarCL.setCellFactory(constuirEliminarCL);
    }  
    
    /**
     * Añade un vehículo nuevo a la lista y una vez añadido se borran los campos textFields
     * @param event 
     */
    @FXML
    private void aniadir(ActionEvent event) {
        
        // Se añade el nuevo vehículo 
        if(!"".equals(matriculaTF.getText())){
            vehiculos.add(new Vehiculo(matriculaTF.getText(),marcaTF.getText(),
                Integer.parseInt(kmTF.getText()),fechaMatriTF.getText(),
                Integer.parseInt(precioTF.getText()),
                propietarioTF.getText()));        
            tablaVehiculos.setItems(vehiculos);
            tablaVehiculos.refresh();
            
            // Se borran los textFields una vez añadidos los datos
            matriculaTF.setText("");
            marcaTF.setText("");
            kmTF.setText("");
            fechaMatriTF.setText("");
            precioTF.setText("");
            propietarioTF.setText("");
        }else{
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("Mensaje de información.");
            alerta.setTitle("Diálogo de advertencia.");
            alerta.setContentText("Es necesario que se introduzca una matrícula.");
            alerta.showAndWait();
        }
        
        
        // Se borran los textFields una vez añadidos los datos
        matriculaTF.setText("");
        marcaTF.setText("");
        kmTF.setText("");
        fechaMatriTF.setText("");
        precioTF.setText("");
        propietarioTF.setText("");
        
    }
    /**
     * Crea un botón 
     * @param toolTip
     * @return 
     */    
    private Button crearBoton(String toolTip){
        Button boton = new Button();
        boton.setTooltip(new Tooltip(toolTip));
        boton.setText("X");
        return boton;
    }
    
}
