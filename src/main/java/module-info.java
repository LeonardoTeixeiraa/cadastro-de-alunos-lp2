module com.empresa.leonardoteixeiralucassiconeli_projetofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires transitive javafx.graphics;
    

    opens com.empresa.leonardoteixeiralucassiconeli_projetofinal.controller to javafx.fxml;
    opens com.empresa.leonardoteixeiralucassiconeli_projetofinal.model to javafx.base, com.google.gson;

    exports com.empresa.leonardoteixeiralucassiconeli_projetofinal;
}
