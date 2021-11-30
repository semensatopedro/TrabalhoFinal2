package com.example.trabalhofinal2.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClienteEmpresarialTest {
    private ClienteEmpresarial cliente = new ClienteEmpresarial("POO S.A", "poo@mail.com", "321", "1231241231", "Poo Solucoes");
    @Test
    void getCnpj() {
        assertEquals(cliente.getCnpj(), "1231241231");
    }

    @Test
    void getColaboradores() {
        assertEquals(cliente.getColaboradores(), new ArrayList<>());
    }

    @Test
    void getNomeFantasia() {
        assertEquals(cliente.getNomeFantasia(), "Poo Solucoes");
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
        assertEquals(cliente.defineTipo(), 2);
    }
}