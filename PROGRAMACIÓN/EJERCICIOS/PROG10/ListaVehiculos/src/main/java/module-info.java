module prog10.listavehiculos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens prog10.listavehiculos to javafx.fxml;
    exports prog10.listavehiculos;
    opens Vehiculo;
}
