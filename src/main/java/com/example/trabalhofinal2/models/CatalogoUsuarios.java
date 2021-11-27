package com.example.trabalhofinal2.models;

import java.util.ArrayList;

public class CatalogoUsuarios {

    private final static ArrayList<Usuario> usuarios = new ArrayList<>();

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean encontraEmailUsuario(Usuario usuario){
        for (Usuario value : usuarios) {
            if (value.getEmail().equals(usuario.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public Usuario buscaUsuarioPorEmail(String email){
        for (Usuario value : usuarios) {
            if (value.getEmail().equals(email)) {
                return value;
            }
        }
        return null;
    }

    public boolean validaSenhaUsuario(Usuario usuario){
        Usuario aux = buscaUsuarioPorEmail(usuario.getEmail());
        if(aux.getSenha().equals(usuario.getSenha())){
            return true;
        }else{
            return false;
        }
    }

    public boolean usuarioDisponivel(Usuario usuario){
        if(encontraEmailUsuario(usuario)) {
            return false;
        }else{
            return true;
        }
    }

    public boolean addUsuarioValido(Usuario usuario){
        if(usuarioDisponivel(usuario)){
            usuarios.add(usuario);
            return true;
        }else{
            return false;
        }

    }




}
