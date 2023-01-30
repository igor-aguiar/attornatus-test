package com.github.igoraguiar.attornatus.GestaoDePessoa.entities;

import com.github.igoraguiar.attornatus.GestaoDePessoa.DTO.PessoaEnderecoData;
import jakarta.persistence.*;
import lombok.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
        this.dataNascimento = pessoa.getDataNascimento();
        this.enderecos.add(new Address(pessoa.endereco(), this));
    }



}
