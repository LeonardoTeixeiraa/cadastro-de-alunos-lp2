package com.empresa.leonardoteixeiralucassiconeli_projetofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Sistema de Cadastro de Alunos");
        stage.setScene(scene);
        stage.show();
    }

    public static Object mudarTela(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("view/" + fxml));
        Scene cena = new Scene(loader.load());
        primaryStage.setScene(cena);
        return loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
