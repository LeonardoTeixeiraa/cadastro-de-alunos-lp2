module com.empresa.leonardoteixeiralucassiconeli_projetofinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.empresa.leonardoteixeiralucassiconeli_projetofinal.controller to javafx.fxml;
    opens com.empresa.leonardoteixeiralucassiconeli_projetofinal.model to javafx.base;

    exports com.empresa.leonardoteixeiralucassiconeli_projetofinal;
}

