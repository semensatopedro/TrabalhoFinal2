package com.example.trabalhofinal2.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class CatalogoAcesso {

    private final static ArrayList<Acesso> acessos = new ArrayList<>();

    public ArrayList<Acesso> getCatalogo() { return acessos; }

    //public boolean addAcesso(Acesso acesso){
//        if(acesso.getCliente().defineTipo() == 3){
//            acesso.setCobranca(acesso.getCobranca() / 2);
//
//            CatalogoUsuarios listaUsuarios = new CatalogoUsuarios();
//            ArrayList<ClienteIndividual> aux = new ArrayList<>();
//            for (Usuario value : listaUsuarios.getUsuarios()) {
//                if (value.defineTipo()==3) {
//                    aux.add((ClienteIndividual) value);
//                }
//            }
//            ClienteEmpresarial empresanova = null;
//            for(ClienteIndividual clienteEspecifico : aux){
//                if(clienteEspecifico.getEmail().equalsIgnoreCase(acesso.getCliente().getEmail())){
//                    empresanova = clienteEspecifico.getEmpresa();
//                }
//            }
//
//            Acesso acessoEmpresa = new Acesso(empresanova,acesso.getEntretenimento());
//            acessoEmpresa.setCobranca(acessoEmpresa.getCobranca() / 2);
//
//            acessos.add(acesso);
//            acessos.add(acessoEmpresa);
//
//            return true;
//        } else if (acesso.getCliente().defineTipo() == 2 || acesso.getCliente().defineTipo() == 1){
//            acessos.add(acesso);
//            return true;
//        }
//        return false;
//    }

    public ArrayList<Acesso> getAcessosDaqueleMes(int ano, int mes){
        ArrayList<Acesso> resultado = new ArrayList<>();
        for (Acesso acesso : acessos) {
            if(acesso.getDataHora().getYear() == ano && acesso.getDataHora().getMonth().getValue() == mes){
                resultado.add(acesso);
            }
        }
        return resultado;
    }

//    public double cobrancaMensal(int ano, int mes){
//        double valorFinal = 0;
//        for (Acesso acesso : getAcessosDaqueleMes(ano, mes)) {
//            valorFinal = valorFinal + acesso.getCobranca();
//        }
//        return valorFinal;
//    }
}

