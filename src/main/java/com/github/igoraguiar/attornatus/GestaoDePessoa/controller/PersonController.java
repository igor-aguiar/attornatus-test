package com.github.igoraguiar.attornatus.GestaoDePessoa.controller;

import com.github.igoraguiar.attornatus.GestaoDePessoa.DTO.PessoaEnderecoData;
import com.github.igoraguiar.attornatus.GestaoDePessoa.entities.Person;
import com.github.igoraguiar.attornatus.GestaoDePessoa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public void registrar(@RequestBody PessoaEnderecoData jsonReq){
        personRepository.save(new Person(jsonReq));
    }
}
