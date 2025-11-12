/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.leonardoteixeiralucassiconeli_projetofinal.service;

import com.empresa.leonardoteixeiralucassiconeli_projetofinal.exception.RegraNegocioException;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.model.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author leonardo-teixeira
 */
public class AlunoService {

    private static AlunoService instance;
    private final ObservableList<Aluno> alunos = FXCollections.observableArrayList();

    private AlunoService() {
    }

    public static AlunoService getInstance() {
        if (instance == null) {
            instance = new AlunoService();
        }
        return instance;
    }

    public void cadastrar(Aluno aluno) throws RegraNegocioException {
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new RegraNegocioException("Nome do aluno é obrigatório.");
        }
        alunos.add(aluno);
    }

  public ObservableList<Aluno> listar() {
      for(Aluno a : alunos){
          System.out.println(a);
      }
        return alunos;
    }
}
