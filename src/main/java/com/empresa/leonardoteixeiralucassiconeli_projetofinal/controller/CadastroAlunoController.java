/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.leonardoteixeiralucassiconeli_projetofinal.controller;

import com.empresa.leonardoteixeiralucassiconeli_projetofinal.App;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.exception.RegraNegocioException;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.factory.MensagemFactory;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.model.Aluno;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.service.AlunoService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author leonardo-teixeira
 */
public class CadastroAlunoController {

    @FXML
    private TextField txtNome, txtMatricula, txtCurso, txtIdade;

    private final AlunoService service = AlunoService.getInstance();

    @FXML
    private void salvarAluno() {
        try {
            Aluno aluno = new Aluno();
            aluno.setNome(txtNome.getText());
            aluno.setMatricula(txtMatricula.getText());
            aluno.setCurso(txtCurso.getText());
            aluno.setIdade(Integer.parseInt(txtIdade.getText()));

            service.cadastrar(aluno);
            MensagemFactory.criarMensagem("sucesso", "Cadastro", "Aluno cadastrado com sucesso!").showAndWait();
        } catch (RegraNegocioException e) {
            MensagemFactory.criarMensagem("erro", "Erro de Cadastro", e.getMessage()).showAndWait();
        } catch (NumberFormatException e) {
            MensagemFactory.criarMensagem("erro", "Erro", "Idade deve ser um número inteiro.").showAndWait();
        }
    }

    @FXML
    private void voltar() throws Exception {
        App.mudarTela("principal.fxml");
    }

}
