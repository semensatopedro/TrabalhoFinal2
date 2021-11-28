package com.example.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EpisodioSerieTest {
    private EpisodioSerie episodioTest;
    private Serie serieTest = new Serie("S01", "Serie Teste", 2012, 2022);
    @BeforeEach
    void instanceTest(){
        episodioTest = new EpisodioSerie("E01", "Episodio1", 2012, 1, 1, serieTest);
    }

    @Test
    void testDefineTipo() {
        int response = episodioTest.defineTipo();
        assertEquals(response, 4);
    }

    @Test
    void testGetNumEpisodio() {
        int response = episodioTest.getNumEpisodio();
        assertEquals(response, 1);
    }

    @Test
    void testGetNumTemporada() {
        int response = episodioTest.getNumTemporada();
        assertEquals(response, 1);
    }

    @Test
    void testGetSerie() {
        Serie response = episodioTest.getSerie();
        assertEquals(response, serieTest);
    }

    @Test
    void testToString() {
        String response = episodioTest.toString();
        String string = "4;Serie Teste;E01;Episodio1;2012;1;1";
        assertEquals(response, string);
    }
}
