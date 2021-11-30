package com.example.trabalhofinal2.models;

import com.example.trabalhofinal2.models.Jogo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JogoTest {
    private Jogo jogoTest;
    @BeforeEach
    void instanceTest(){
        jogoTest = new Jogo("J01", "Jogo Teste", 1979, "Jogo Teste", "acao");
    }

    @Test
    void testDefineTipo() {
        int response = jogoTest.defineTipo();
        assertEquals(response, 2);
    }

    @Test
    void testGetGenero() {
        String response = jogoTest.getGenero();
        assertEquals(response, "acao");
    }

    @Test
    void testGetTituloOriginal() {
        String response = jogoTest.getTituloOriginal();
        assertEquals(response, "Jogo Teste");
    }

    @Test
    void testToString() {
        String response = jogoTest.toString();
        String string = "2;J01;Jogo Teste;1979;Jogo Teste;acao";
        assertEquals(response, string);
    }
}
