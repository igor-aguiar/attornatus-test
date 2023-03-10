package com.github.igoraguiar.attornatus.GestaoDePessoa.DTO;

import com.github.igoraguiar.attornatus.GestaoDePessoa.entities.Address;

public record EnderecoData(String logradouro, String cep, String numero, String cidade) {

    public EnderecoData(Address endereco){
        this(endereco.getLogradouro(),
        endereco.getCep(),
        endereco.getNumero(),
        endereco.getCidade());
    }
}
