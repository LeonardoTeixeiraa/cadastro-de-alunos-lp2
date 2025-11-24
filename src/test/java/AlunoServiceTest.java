/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leonardo-teixeira
 */

import com.empresa.leonardoteixeiralucassiconeli_projetofinal.exception.RegraNegocioException;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.model.Aluno;
import com.empresa.leonardoteixeiralucassiconeli_projetofinal.service.AlunoService;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoServiceTest {

    private AlunoService service;

    @BeforeEach
    void setUp() {
        service = AlunoService.getInstance();

        ObservableList<Aluno> lista = service.listar();
        lista.clear();
    }

    @Test
    void deveCadastrarAlunoComSucesso() throws RegraNegocioException {
        Aluno aluno = new Aluno();
        aluno.setNome("Carlos");
        aluno.setMatricula("2023001");
        aluno.setCurso("ADS");
        aluno.setIdade(19);

        service.cadastrar(aluno);

        assertEquals(1, service.listar().size());
        assertEquals("Carlos", service.listar().get(0).getNome());
    }

    @Test
    void naoDeveCadastrarAlunoComNomeVazio() {
        Aluno aluno = new Aluno();
        aluno.setNome(""); 
        aluno.setCurso("Sistemas");
        aluno.setMatricula("2023999");
        aluno.setIdade(18);

        assertThrows(RegraNegocioException.class, () -> service.cadastrar(aluno));
    }

    @Test
    void deveRemoverAlunoComSucesso() throws RegraNegocioException {
        Aluno aluno = new Aluno();
        aluno.setNome("Ana");
        aluno.setMatricula("8888");
        aluno.setCurso("ADS");
        aluno.setIdade(20);

        service.cadastrar(aluno);

        assertEquals(1, service.listar().size());

        service.remover(aluno);

        assertEquals(0, service.listar().size());
    }

    @Test
    void listarDeveRetornarListaAtualizada() throws RegraNegocioException {
        Aluno a1 = new Aluno();
        a1.setNome("Lucas");
        a1.setMatricula("1001");
        a1.setCurso("Computação");
        a1.setIdade(21);

        Aluno a2 = new Aluno();
        a2.setNome("Roberta");
        a2.setMatricula("1002");
        a2.setCurso("Engenharia");
        a2.setIdade(22);

        service.cadastrar(a1);
        service.cadastrar(a2);

        ObservableList<Aluno> lista = service.listar();

        assertEquals(2, lista.size());
        assertTrue(lista.contains(a1));
        assertTrue(lista.contains(a2));
    }
}
