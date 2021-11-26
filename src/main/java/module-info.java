module com.example.trabalhofinal2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.trabalhofinal2 to javafx.fxml;
    exports com.example.trabalhofinal2;
    exports com.example.trabalhofinal2.controllers;
    opens com.example.trabalhofinal2.controllers to javafx.fxml;
}