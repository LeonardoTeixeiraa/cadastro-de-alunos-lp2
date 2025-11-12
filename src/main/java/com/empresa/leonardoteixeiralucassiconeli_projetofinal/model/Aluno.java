/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.leonardoteixeiralucassiconeli_projetofinal.model;

/**
 *
 * @author leonardo-teixeira
 */
public class Aluno {

    private String nome;
    private String matricula;
    private String curso;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    //Método usado para realizar debug
    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome
                + "\n, matricula=" + matricula
                + "\n,, curso=" + curso
                + "\n,, idade=" + idade + '}';
    }

}
