/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.leonardoteixeiralucassiconeli_projetofinal.repository;

/**
 *
 * @author leonardo-teixeira
 */
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.model.Aluno;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryJSON {

    private static final String FILE_PATH = "alunos.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvar(List<Aluno> alunos) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(alunos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Aluno> carregar() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Aluno>>() {
            }.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>(); 
        }
    }
}
