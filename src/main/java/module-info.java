module com.empresa.leonardoteixeiralucassiconeli_projetofinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.empresa.leonardoteixeiralucassiconeli_projetofinal to javafx.fxml;
    exports com.empresa.leonardoteixeiralucassiconeli_projetofinal;
}
