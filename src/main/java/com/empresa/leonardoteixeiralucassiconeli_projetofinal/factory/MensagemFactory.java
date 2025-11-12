/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.leonardoteixeiralucassiconeli_projetofinal.factory;

import javafx.scene.control.Alert;

/**
 *
 * @author leonardo-teixeira
 */
public class MensagemFactory {

    public static Alert criarMensagem(String tipo, String titulo, String mensagem) {
        Alert alert;
        switch (tipo.toLowerCase()) {
            case "erro":
                alert = new Alert(Alert.AlertType.ERROR);
                break;
            case "sucesso":
                alert = new Alert(Alert.AlertType.INFORMATION);
                break;
            default:
                alert = new Alert(Alert.AlertType.WARNING);
        }
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        return alert;
    }
}
