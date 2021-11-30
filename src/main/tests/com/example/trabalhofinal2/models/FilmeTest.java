package com.example.trabalhofinal2.models;

import com.example.trabalhofinal2.models.Filme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmeTest {
    private Filme filmeTest;
    @BeforeEach
    void instanceTest(){
        filmeTest = new Filme("F01", "Filme Teste", 2000, 115);
    }

    @Test
    void testDefineTipo() {
        int response = filmeTest.defineTipo();
        assertEquals(response, 1);
    }

    @Test
    void testGetTempoDuracao() {
        int response = filmeTest.getTempoDurcao();
        assertEquals(response, 115);
    }

    @Test
    void testToString() {
        String response = filmeTest.toString();
        String string = "1;F01;Filme Teste;2000;115";
        assertEquals(response, string);
    }
}
