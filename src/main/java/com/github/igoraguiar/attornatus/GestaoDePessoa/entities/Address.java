package com.github.igoraguiar.attornatus.GestaoDePessoa.entities;

import com.github.igoraguiar.attornatus.GestaoDePessoa.DTO.EnderecoData;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "enderecos")
@Entity(name = "Endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private boolean principal;
    @ManyToOne
    private Person pessoa;

    Address (EnderecoData endereco, Person pessoa){
        this.logradouro = endereco.logradouro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.numero = endereco.numero();
        this.pessoa = pessoa;
        this.principal = true;
    }

    public void atualizaDados(EnderecoData dados){
        if (dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
        if (dados.numero() != null){
            this.numero = dados.numero();
        }
        if (dados.cep() != null){
            this.cep = dados.cep();
        }
        if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "logradouro='" + logradouro + '\'' +
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                ", principal=" + principal +
                '}';
    }
}
