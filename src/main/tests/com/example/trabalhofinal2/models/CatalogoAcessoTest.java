package com.example.trabalhofinal2.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CatalogoAcessoTest {
    private CatalogoAcesso catalogo;
    private Entretenimento entr1 = new Filme("F01", "Filme Teste", 2000, 115);
    private Entretenimento entr2 = new Jogo("J01", "Jogo Teste", 1979, "Jogo Teste", "acao");
    private ClienteEmpresarial cliente1 = new ClienteEmpresarial("Yamaguti S.A", "yama@mail.com", "010203", "0987654321", "Yamaguti Co.");
    private ClienteIndividual cliente2 = new ClienteIndividual("Carla", "email2", "321", "12345678911", null);
    private Acesso ac1 = new Acesso(cliente1, entr1);
    private Acesso ac2 = new Acesso(cliente2, entr1);
    private Acesso ac3 = new Acesso(cliente2, entr2);

    @BeforeEach
    void carregaDados() {
        catalogo.addAcesso(ac1);
        catalogo.addAcesso(ac2);
        catalogo.addAcesso(ac3);
    }

    @Test
    void getCatalogo() {
        ArrayList<Acesso> array = new ArrayList<>();
        array.add(ac1);
        array.add(ac2);
        array.add(ac3);
        assertEquals(catalogo.getCatalogo(), array);
    }

    @Test
    void addAcesso() {
        assertTrue(catalogo.addAcesso(ac3));
    }

    @Test
        void getAcessosDaqueleMesGeral() {
            ArrayList<Acesso> array = new ArrayList<>();
            array.add(ac1);
            array.add(ac2);
            array.add(ac3);
            assertEquals(catalogo.getAcessosDaqueleMesGeral(2021, 11), array);
    }

    @Test
    void getAcessosDaqueleMesCliente() {
        ArrayList<Acesso> array = new ArrayList<>();
        array.add(ac2);
        array.add(ac3);
        assertEquals(catalogo.getAcessosDaqueleMesCliente(catalogo.getAcessosDaqueleMesGeral(2021, 11), cliente2), array);
    }

    @Test
    void getRelatório() {
        assertEquals(catalogo.getRelatório(new ArrayList<Acesso>()), "");
    }

    @Test
    void cobrancaMensalGeral() {
        double cobranca = catalogo.cobrancaMensalGeral(2021, 11);
        assertEquals(cobranca, 20);
    }

    @Test
    void cobrancaMensalCliente() {
        double cobrancaCliente = catalogo.cobrancaMensalCliente(2020, 11, new ArrayList<>(), cliente1);
        assertEquals(cobrancaCliente, 0);
    }
}