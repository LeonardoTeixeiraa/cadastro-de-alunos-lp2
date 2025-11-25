package com.empresa.leonardoteixeiralucassiconeli_projetofinal.controller;

import com.empresa.leonardoteixeiralucassiconeli_projetofinal.App;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.exception.RegraNegocioException;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.factory.MensagemFactory;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.model.Aluno;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.service.AlunoService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroAlunoController {

    @FXML
    private TextField txtNome, txtMatricula, txtCurso, txtIdade;

    @FXML
    private Button btnSalvar;

    private final AlunoService service = AlunoService.getInstance();
    private Aluno alunoEmEdicao = null;

    @FXML
    private void salvarAluno() {
        try {
            if (alunoEmEdicao == null) {
                cadastrarNovoAluno();
            } else {
                atualizarAlunoExistente();
            }
            limparCampos();
        } catch (Exception e) {
            MensagemFactory.criarMensagem("erro", "Erro", e.getMessage()).showAndWait();
        }
    }

    private void cadastrarNovoAluno() throws RegraNegocioException {
        Aluno aluno = new Aluno();
        aluno.setNome(txtNome.getText());
        aluno.setMatricula(txtMatricula.getText());
        aluno.setCurso(txtCurso.getText());
        aluno.setIdade(Integer.parseInt(txtIdade.getText()));

        service.cadastrar(aluno);
        MensagemFactory.criarMensagem("sucesso", "Cadastro", "Aluno cadastrado com sucesso!").showAndWait();
    }

    private void atualizarAlunoExistente() throws RegraNegocioException {
        alunoEmEdicao.setNome(txtNome.getText());
        alunoEmEdicao.setMatricula(txtMatricula.getText());
        alunoEmEdicao.setCurso(txtCurso.getText());
        alunoEmEdicao.setIdade(Integer.parseInt(txtIdade.getText()));
        
        service.atualizarAluno(alunoEmEdicao, alunoEmEdicao);
        MensagemFactory.criarMensagem("sucesso", "Atualização", "Aluno atualizado com sucesso!").showAndWait();
    }

    public void carregarAlunoParaEdicao(Aluno aluno) {
        this.alunoEmEdicao = aluno;

        txtNome.setText(aluno.getNome());
        txtMatricula.setText(aluno.getMatricula());
        txtCurso.setText(aluno.getCurso());
        txtIdade.setText(String.valueOf(aluno.getIdade()));

        btnSalvar.setText("Salvar alterações");
    }

    @FXML
    private void limparCampos() {
        txtNome.clear();
        txtMatricula.clear();
        txtCurso.clear();
        txtIdade.clear();
    }

    @FXML
    private void voltar() throws Exception {
        App.mudarTela("principal.fxml");
    }
}
