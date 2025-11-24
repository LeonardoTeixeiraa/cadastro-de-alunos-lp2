/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leonardo-teixeira
 */

import com.empresa.leonardoteixeiralucassiconeli_projetofinal.model.Aluno;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    @Test
    void deveDefinirEObterAtributosCorretamente() {
        Aluno aluno = new Aluno();

        aluno.setNome("João");
        aluno.setMatricula("2021001");
        aluno.setCurso("Computação");
        aluno.setIdade(20);

        assertEquals("João", aluno.getNome());
        assertEquals("2021001", aluno.getMatricula());
        assertEquals("Computação", aluno.getCurso());
        assertEquals(20, aluno.getIdade());
    }

    @Test
    void toStringNaoDeveRetornarNull() {
        Aluno aluno = new Aluno();
        aluno.setNome("Maria");
        aluno.setMatricula("2021002");
        aluno.setCurso("Engenharia");
        aluno.setIdade(22);

        String texto = aluno.toString();

        assertNotNull(texto);
        assertTrue(texto.contains("Maria"));
        assertTrue(texto.contains("2021002"));
    }
}

