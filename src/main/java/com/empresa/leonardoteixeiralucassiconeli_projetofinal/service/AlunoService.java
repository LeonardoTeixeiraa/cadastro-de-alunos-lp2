/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.leonardoteixeiralucassiconeli_projetofinal.service;

import com.empresa.leonardoteixeiralucassiconeli_projetofinal.exception.RegraNegocioException;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.model.Aluno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo-teixeira
 */
public class AlunoService {

    private List<Aluno> alunos = new ArrayList<>();

    public void cadastrar(Aluno aluno) throws RegraNegocioException {
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new RegraNegocioException("Nome do aluno é obrigatório.");
        }
        alunos.add(aluno);
    }

    public List<Aluno> listar() {
        return alunos;
    }
}
