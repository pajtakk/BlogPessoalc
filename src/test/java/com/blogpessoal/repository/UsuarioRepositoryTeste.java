package com.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTeste {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start() {
        usuarioRepository.deleteAll();
        usuarioRepository.save(new Usuario(0L, "João da Silva","url", "teste@teste.com", "12345678"));
        usuarioRepository.save(new Usuario(0L, "Manuela da Silva","url", "teste@teste.com2", "12345678"));
        usuarioRepository.save(new Usuario(0L, "Adriana da Silva","url", "teste@teste.com3", "12345678"));
        usuarioRepository.save(new Usuario(0L, "Dean Winchester","url", "teste@teste.com4", "12345678"));
    }

    @Test
    @DisplayName("Retorna um usuário")
    public void retornarUsuario() {
        Optional<Usuario> usuario = usuarioRepository.findByUsuario("teste@teste.com");
        assertTrue(usuario.get().getUsuario().equals("teste@teste.com"));
    }
@Test
    @DisplayName("Retorna 3 usuarios")
    public void deveRetornarTresUsuarios() {

        List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("silva");

        assertEquals(3, listaDeUsuarios.size());

        assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
        assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
        assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));

    }


    @AfterAll
    public void end() {
        usuarioRepository.deleteAll();
    }

}