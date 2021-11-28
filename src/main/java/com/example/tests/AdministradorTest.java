package com.example.tests;

import java.io.File;

import org.junit.jupiter.api.Test;

public class AdministradorTest {
    private Administrador adm = new Administrador("administracao@mail.com", "adm123");

    @Test
    void testReadFile() {
        adm.readFile(new File("src/main/java/com/example/trabalhofinal2/models/Administrador.java"));
    }

    @Test
    void testWriteFile() {
        adm.writeFile(new File("src/main/resources/com/example/trabalhofinal2/arquivos/teste.dat"), "Conteudo de teste");
    }
}
