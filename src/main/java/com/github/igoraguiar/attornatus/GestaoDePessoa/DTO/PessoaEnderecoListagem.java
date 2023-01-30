package com.github.igoraguiar.attornatus.GestaoDePessoa.DTO;

import com.github.igoraguiar.attornatus.GestaoDePessoa.entities.Address;
import com.github.igoraguiar.attornatus.GestaoDePessoa.entities.Person;

import java.util.List;

public record PessoaEnderecoListagem(Long id, String nome, String dataNascimento, EnderecoListagem endereco) {

    public PessoaEnderecoListagem(Person pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento().toString(), new EnderecoListagem(pessoa.enderecoPrincipal()));
    }
}
