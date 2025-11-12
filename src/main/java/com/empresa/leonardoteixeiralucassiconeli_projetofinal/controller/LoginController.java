package com.empresa.leonardoteixeiralucassiconeli_projetofinal.controller;

import com.empresa.leonardoteixeiralucassiconeli_projetofinal.App;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.factory.MensagemFactory;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtSenha;

    @FXML
    private void entrar() {
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (usuario.equals("admin") && senha.equals("1234")) {
            try {
                App.mudarTela("principal.fxml");
            } catch (Exception e) {
                MensagemFactory.criarMensagem("erro", "Erro", "Não foi possível abrir a tela principal.").showAndWait();
            }
        } else {
            MensagemFactory.criarMensagem("erro", "Acesso negado", "Usuário ou senha incorretos.").showAndWait();
        }
    }
}
