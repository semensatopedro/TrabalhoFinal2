package com.example.trabalhofinal2.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteIndividualTest {
    private ClienteIndividual cliente = new ClienteIndividual("Marcelo", "marcelo@mail.com", "432", "12345678910", null);
    @Test
    void getCpf() {
        assertEquals(cliente.getCpf(), "12345678910");
    }

    @Test
    void getEmpresa() {
        assertEquals(cliente.getEmpresa(), null);
    }

    @Test
    void cobrancaMensal() {
        assertEquals(cliente.cobrancaMensal(2021, 11), 0);
    }

    @Test
    void testToString() {
        String str = "2;POO S.A;poo@mail.com;321;1231241231;Poo Solucoes";
        assertEquals(cliente.toString(), str);
    }

    @Test
    void defineTipo() {
        assertEquals(cliente.defineTipo(), 1);
    }
}