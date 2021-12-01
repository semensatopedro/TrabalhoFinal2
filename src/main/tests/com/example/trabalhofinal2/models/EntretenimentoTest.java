package com.example.trabalhofinal2.models;

import com.example.trabalhofinal2.models.Entretenimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntretenimentoTest {
    private Entretenimento entretenimentoTest;
    @BeforeEach
    void instanceTest(){
        entretenimentoTest = new Entretenimento("01", "Entretenimento", 2002);
    }
    @Test
    void testDefineTipo() {
        int response = entretenimentoTest.defineTipo();
        assertEquals(response, 0);
    }

    @Test
    void testGetAnoLancamento() {
        int response = entretenimentoTest.getAnoLancamento();
        assertEquals(response, 2002);
    }

    @Test
    void testGetCodigo() {
        String response = entretenimentoTest.getCodigo();
        assertEquals(response, "01");
    }

    @Test
    void testGetTipo() {
        int response = entretenimentoTest.getTipo();
        assertEquals(response, 0);
    }

    @Test
    void testGetTitulo() {
        String response = entretenimentoTest.getTitulo();
        assertEquals(response, "Entretenimento");
    }
}
