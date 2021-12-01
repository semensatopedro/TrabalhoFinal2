package com.example.trabalhofinal2.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    private Cliente cliente = new Cliente("email", "senha123", "Marcelo");
    @Test
    void getNome() {
        assertEquals(cliente.getNome(), "Marcelo");
    }

    @Test
    void getTipo() {
        assertEquals(cliente.getTipo(), 0);
    }

    @Test
    void getAcessosDaqueleMes() {
        assertEquals(cliente.getAcessosDaqueleMes(2020, 11).size(), 0);
    }

    @Test
    void cobrancaMensal() {
        double cobranca = cliente.cobrancaMensal(2020, 11);
        assertEquals(cobranca, 0);
    }

    @Test
    void defineTipo() {
        assertEquals(cliente.defineTipo(), 0);
    }

    @Test
    void testToString() {
        assertEquals(cliente.toString(), "");
    }
}