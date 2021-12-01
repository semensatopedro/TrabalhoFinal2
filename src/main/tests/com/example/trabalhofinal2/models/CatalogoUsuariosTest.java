package com.example.trabalhofinal2.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

public class CatalogoUsuariosTest {
    private CatalogoUsuarios catalogo;
    private ClienteIndividual cliente1 = new ClienteIndividual("Arlindo", "email1", "123", "12345678910", null);
    private ClienteEmpresarial cliente2 = new ClienteEmpresarial("Yamaguti S.A", "yama@mail.com", "010203", "0987654321", "Yamaguti Co.");
    private ClienteIndividual cliente3 = new ClienteIndividual("Carla", "email2", "321", "12345678911", cliente2);
    @BeforeEach
    void carregaDados(){
        catalogo = new CatalogoUsuarios();
        catalogo.addClienteValido(cliente1);
        catalogo.addClienteValido(cliente2);
        catalogo.addClienteValido(cliente3);
    }

    @Test
    void testAddClienteValido() {
        Cliente cValido = new ClienteIndividual("Jose", "mail@mail.com", "123", "12341234123", null);
        assertTrue(catalogo.addClienteValido(cValido));

        Cliente cInvalido = new ClienteIndividual("Andre", "mail@mail.com", "1235124", "32341234121", null);
        assertFalse(catalogo.addClienteValido(cInvalido));
    }

    @Test
    void testBuscaUsuarioPorEmail() {
        Usuario response = catalogo.buscaUsuarioPorEmail("yama@mail.com");
        assertEquals(response.toString(), cliente2.toString());
    }

    @Test
    void testEncontraEmailUsuario() {
        boolean encontraUsuarioAdicionado = catalogo.encontraEmailUsuario(cliente1);
        assertTrue(encontraUsuarioAdicionado);

        boolean encontraUsuarioNaoAdicionado = catalogo.encontraEmailUsuario(new ClienteEmpresarial("Ghost Company S.A", "gc@mail.com", "123123", "12341213", "ghost company"));
        assertFalse(encontraUsuarioNaoAdicionado);

    }

    @Test
    void testGetUsuarios() {
        ArrayList<Usuario> response = catalogo.getUsuarios();
        assertEquals(response, catalogo.getUsuarios());
    }

    @Test
    void testListaClientesEmpresariais() {
        assertEquals(catalogo.listaClientesEmpresariais().size(), 1);
    }

    

    @Test
    void testUsuarioDisponivel() {
        Usuario novoUser = new ClienteIndividual("Jose", "mail@mail.com", "123", "12341234123", null);
        boolean responseTrue = catalogo.usuarioDisponivel(novoUser);
        assertTrue(responseTrue);

        boolean responseFalse = catalogo.usuarioDisponivel(cliente1);
        assertFalse(responseFalse);
    }

    @Test
    void testValidaSenhaUsuario() {
        Usuario userInvalido = new ClienteIndividual("Arlindo", "email1", "321", "12345678910", null);
        boolean responseFalse = catalogo.validaSenhaUsuario(userInvalido);
        assertFalse(responseFalse);

        boolean responseTrue = catalogo.validaSenhaUsuario(cliente1);
        assertTrue(responseTrue);
    }
}
