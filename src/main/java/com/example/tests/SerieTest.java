package com.example.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SerieTest {
    private Serie serieTest;
    @BeforeEach
    void instanceTest(){
        serieTest = new Serie("S01", "Serie Teste", 2021, 2022);
    }

    @Test
    void testDefineTipo() {
        int response = serieTest.defineTipo();
        assertEquals(response, 3);
    }

    @Test
    void testGetAnoConclusao() {
        int response = serieTest.getAnoConclusao();
        assertEquals(response, 2022);
    }

    @Test
    void testGetEpisodios() {
        ArrayList<EpisodioSerie> response = serieTest.getEpisodios();
        assertEquals(response, null);
    }

    @Test
    void testToString() {
        String response = serieTest.toString();
        String string = "3;S01;Serie Teste;2021;2022";
        assertEquals(response, string);
    }
}
