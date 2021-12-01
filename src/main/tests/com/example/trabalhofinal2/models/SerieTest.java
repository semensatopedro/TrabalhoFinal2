package com.example.trabalhofinal2.models;

import com.example.trabalhofinal2.models.EpisodioSerie;
import com.example.trabalhofinal2.models.Serie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
