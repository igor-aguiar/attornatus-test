package com.github.igoraguiar.attornatus.GestaoDePessoa.DTO;

import com.github.igoraguiar.attornatus.GestaoDePessoa.entities.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record PessoaEnderecoData(String nome, String dataNascimento, EnderecoData endereco) {
}
