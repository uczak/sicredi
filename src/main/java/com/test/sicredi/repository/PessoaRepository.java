package com.test.sicredi.repository;

import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {

}
