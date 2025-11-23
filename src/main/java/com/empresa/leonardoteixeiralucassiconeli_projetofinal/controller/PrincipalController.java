package com.empresa.leonardoteixeiralucassiconeli_projetofinal.controller;

import com.empresa.leonardoteixeiralucassiconeli_projetofinal.App;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.model.Aluno;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.service.AlunoService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class PrincipalController {

    @FXML
    private TableView<Aluno> tabelaAlunos;
    @FXML
    private TableColumn<Aluno, String> colNome;
    @FXML
    private TableColumn<Aluno, String> colMatricula;
    @FXML
    private TableColumn<Aluno, String> colCurso;
    @FXML
    private TableColumn<Aluno, Integer> colIdade;
    @FXML
    private TextField txtPesquisa;

    private final AlunoService service = AlunoService.getInstance();

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        colCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));
        colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));

        tabelaAlunos.setItems(service.listar());
    }

    @FXML
    private void pesquisarAluno() {
        String termo = txtPesquisa.getText().toLowerCase();

        if (termo.isBlank()) {
            tabelaAlunos.setItems(service.listar());
            return;
        }

        var filtrados = service.listar().filtered(aluno
                -> aluno.getNome().toLowerCase().contains(termo)
                || aluno.getMatricula().toLowerCase().contains(termo)
        );

        tabelaAlunos.setItems(filtrados);
    }
    
    @FXML
private void excluirAluno() {

    Aluno alunoSelecionado = tabelaAlunos.getSelectionModel().getSelectedItem();

    if (alunoSelecionado == null) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Nenhum aluno selecionado");
        alerta.setHeaderText("Selecione um aluno na tabela para excluir.");
        alerta.showAndWait();
        return;
    }

    Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
    confirmacao.setTitle("Confirmar exclusão");
    confirmacao.setHeaderText("Deseja excluir o aluno selecionado?");
    confirmacao.setContentText(
            "Aluno: " + alunoSelecionado.getNome() + "\nMatrícula: " + alunoSelecionado.getMatricula()
    );

    Optional<ButtonType> resultado = confirmacao.showAndWait();

    if (resultado.isPresent() && resultado.get() == ButtonType.OK) {

        service.remover(alunoSelecionado);
        tabelaAlunos.setItems(service.listar());

        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        sucesso.setTitle("Aluno removido");
        sucesso.setHeaderText("Aluno removido com sucesso!");
        sucesso.showAndWait();
    }
}


    @FXML
    private void abrirCadastroAluno() throws Exception {
        App.mudarTela("cadastroAluno.fxml");
    }

    @FXML
    private void logout() throws Exception {

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmar Logout");
        alerta.setHeaderText("Deseja realmente sair da sua conta?");
        alerta.setContentText("Você será redirecionado para a tela de login.");

        Optional<ButtonType> resultado = alerta.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            // Usuário confirmou — faz o logout
            App.mudarTela("login.fxml");
        } 
        // Se o usuário clicar em CANCELAR, nada acontece.
    }
}
