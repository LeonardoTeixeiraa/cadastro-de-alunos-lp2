package com.empresa.leonardoteixeiralucassiconeli_projetofinal.controller;

import com.empresa.leonardoteixeiralucassiconeli_projetofinal.App;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.model.Aluno;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.service.AlunoService;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;

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
    private void abrirCadastroAluno() throws Exception {
        App.mudarTela("cadastroAluno.fxml");
    }

    @FXML
    private void logout() throws Exception {
        App.mudarTela("login.fxml");
    }
}
