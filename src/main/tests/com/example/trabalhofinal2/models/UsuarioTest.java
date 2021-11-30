package com.example.trabalhofinal2.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {
    private Usuario userTest;
    @BeforeEach
    void instanceUser(){
        userTest = new Usuario("test@mail.com", "test123");
    }

    @Test
    void testDefineTipo() {
        int response = userTest.defineTipo();
        assertEquals(response, 0);
    }

    @Test
    void testGetEmail() {
        String response = userTest.getEmail();
        assertEquals(response, "test@mail.com");
    }

    @Test
    void testGetSenha() {
        String response = userTest.getSenha();
        assertEquals(response, "test123");
    }

    @Test
    void testSetEmail() {
        userTest.setEmail("testCorrect@mail.com");
        assertEquals(userTest.getEmail(), "testCorrect@mail.com");
    }

    @Test
    void testSetSenha() {
        userTest.setSenha("test1234");
        assertEquals(userTest.getSenha(), "test1234");
    }
}
