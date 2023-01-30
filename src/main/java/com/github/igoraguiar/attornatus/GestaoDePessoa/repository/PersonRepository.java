package com.github.igoraguiar.attornatus.GestaoDePessoa.repository;

import com.github.igoraguiar.attornatus.GestaoDePessoa.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
