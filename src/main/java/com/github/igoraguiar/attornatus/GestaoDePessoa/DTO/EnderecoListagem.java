package com.github.igoraguiar.attornatus.GestaoDePessoa.DTO;

import com.github.igoraguiar.attornatus.GestaoDePessoa.entities.Address;

public record EnderecoListagem(String logradouro, String cep, String numero, String cidade, Boolean principal) {

    public EnderecoListagem(Address endereco){
        this(endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), endereco.isPrincipal());
    }
}