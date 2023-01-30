package com.github.igoraguiar.attornatus.GestaoDePessoa.DTO;

import com.github.igoraguiar.attornatus.GestaoDePessoa.entities.Address;

public record EnderecoDataId(Long id, String logradouro, String cep, String numero, String cidade) {

    public EnderecoDataId(Address endereco){
        this(endereco.getId(), endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade());
    }
}
