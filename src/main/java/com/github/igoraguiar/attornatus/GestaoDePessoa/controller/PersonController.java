package com.github.igoraguiar.attornatus.GestaoDePessoa.controller;

import com.github.igoraguiar.attornatus.GestaoDePessoa.DTO.*;
import com.github.igoraguiar.attornatus.GestaoDePessoa.entities.Person;
import com.github.igoraguiar.attornatus.GestaoDePessoa.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    @Transactional
    public void registrar(@RequestBody PessoaEnderecoData jsonReq){
        personRepository.save(new Person(jsonReq));
    }

    @GetMapping
    public List<PessoaEnderecoListagem> listarPessoas(){
        return personRepository.findAll().stream().map(PessoaEnderecoListagem::new).toList();
    }

    @GetMapping("/{id}")
    public PessoaEnderecoListagem consultarPessoa(@PathVariable Long id){
        return new PessoaEnderecoListagem(personRepository.getReferenceById(id));
    }

    @PutMapping
    @Transactional
    public void editarPessoa(@RequestBody AtualizacaoPessoaData jsonReq){
        var pessoa = personRepository.getReferenceById(jsonReq.id());
        pessoa.atualizaDados(jsonReq);
    }

    @PostMapping("/{id}/novoEndereco")
    @Transactional
    public void novoEndereco(@RequestBody EnderecoData dados, @PathVariable Long id){
        var pessoa = personRepository.getReferenceById(id);
        pessoa.novoEdereco(dados);
    }

    @GetMapping("/{id}/enderecos")
    public List<EnderecoDataId> enderecosCadastrados(@PathVariable Long id){
        var pessoa = personRepository.getReferenceById(id);
        return pessoa.getEnderecos().stream().map(EnderecoDataId::new).toList();
    }

    @PutMapping("/{idPessoa}/enderecos")
    @Transactional
    public void definirEnderecoPrincipal(@RequestBody EnderecoDataId endereco, @PathVariable Long idPessoa){
        var pessoa = personRepository.getReferenceById(idPessoa);
        pessoa.novoEnderecoPrincipal(endereco);
    }

}
