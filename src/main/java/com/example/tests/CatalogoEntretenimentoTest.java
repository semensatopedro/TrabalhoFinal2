package com.example.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatalogoEntretenimentoTest {
    private CatalogoEntretenimento catalogo;
    private Entretenimento entr1 = new Serie("S01", "Serie Teste", 2021, 2022);
    private Entretenimento entr2 = new Filme("F01", "Filme Teste", 2000, 115);
    private Entretenimento entr3 = new Jogo("J01", "Jogo Teste", 1979, "Jogo Teste", "acao");
    @BeforeEach
    void carregaDados(){
        catalogo = new CatalogoEntretenimento();
        catalogo.addEntretenimentoValido(entr1);
        catalogo.addEntretenimentoValido(entr2);
        catalogo.addEntretenimentoValido(entr3);
    }
    @Test
    void testAddEntretenimentoValido() {
        Entretenimento novoEntr = new Serie("S02", "Serie Teste2", 2020, 2022);
        assertTrue(catalogo.addEntretenimentoValido(novoEntr));

        assertFalse(catalogo.addEntretenimentoValido(entr1));
    }

    @Test
    void testBuscaSerie() {
        Serie response = catalogo.buscaSerie("Serie Teste");
        assertEquals(response, (Serie)entr1);
    }

    @Test
    void testCodigoUnico() {
        Entretenimento novoEntr = new Serie("S02", "Serie Teste2", 2020, 2022);
        assertTrue(catalogo.codigoUnico(novoEntr));

        assertFalse(catalogo.codigoUnico(entr1));
    }

    @Test
    void testGetCatalogo() {
        ArrayList<Entretenimento> response = catalogo.getCatalogo();
        assertEquals(response, catalogo.getCatalogo());
    }

    @Test
    void testListaNomeSeries() {
        ArrayList<String> response = catalogo.listaNomeSeries();

        ArrayList<String> arrString = new ArrayList<>();
        arrString.add("Serie Teste");
        
        assertEquals(response, arrString);
    }
}
