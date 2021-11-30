package com.example.trabalhofinal2.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AcessoTest {
    private Cliente cliente1 = new ClienteIndividual("Arlindo", "email1", "123", "12345678910", null);
    private Entretenimento entr1 = new Entretenimento("01", "Entretenimento", 2002);
    private Acesso acessoTest = new Acesso(cliente1, entr1);

    @Test
    void getCliente() {
        assertEquals(acessoTest.getCliente(), cliente1);
    }

    @Test
    void getEntretenimento() {
        assertEquals(acessoTest.getEntretenimento(), entr1);
    }

    @Test
    void getDataHora() {
        assertEquals(acessoTest.getDataHora(), LocalDate.now());
    }

    @Test
    void setCobrancaTest() {
        acessoTest.setCobranca(1);
        assertEquals(acessoTest.getCobranca(), 1);
    }

    @Test
    void getCobrancaTest() {
        assertEquals(acessoTest.getCobranca(), 1);
    }

    @Test
    void toStringTest() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy;HH:mm");
        String data = dtf.format(LocalDate.now());
        String resultado = data + ";" + cliente1.getEmail() + ";" + entr1.getCodigo();

        assertEquals(acessoTest.toString(), resultado);
    }
}