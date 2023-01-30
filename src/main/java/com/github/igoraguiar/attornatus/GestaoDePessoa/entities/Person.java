package com.github.igoraguiar.attornatus.GestaoDePessoa.entities;

import com.github.igoraguiar.attornatus.GestaoDePessoa.DTO.AtualizacaoPessoaData;
import com.github.igoraguiar.attornatus.GestaoDePessoa.DTO.EnderecoData;
import com.github.igoraguiar.attornatus.GestaoDePessoa.DTO.PessoaEnderecoData;
import jakarta.persistence.*;
import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Date dataNascimento;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> enderecos = new ArrayList<>();

    public Person(PessoaEnderecoData pessoa) {
        this.nome = pessoa.nome();
        this.dataNascimento = this.converterDataNascimento(pessoa.dataNascimento());
        this.enderecos.add(new Address(pessoa.endereco(), this));
    }

    public Address enderecoPrincipal(){
        Address principal = enderecos.stream().filter(Address::isPrincipal).collect(Collectors.toList()).get(0);
        return principal;
    }

    public void atualizaDados(AtualizacaoPessoaData dados){
        if (dados.dataNascimento() != null){
            this.dataNascimento = this.converterDataNascimento(dados.dataNascimento());
        }
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.endereco() != null){
            this.enderecoPrincipal().atualizaDados(dados.endereco());
        }
    }
    public Date converterDataNascimento(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimentoDate;
        try {
            dataNascimentoDate = sdf.parse(data);
        } catch (ParseException e){
            return new Date();
        }
        return dataNascimentoDate;
    }



}
