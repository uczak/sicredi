package com.test.sicredi.service;

import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Pessoa findById(String pessoaId) {
        return pessoaRepository.findById(pessoaId).orElse(null);
    }

    @Transactional(readOnly = false)
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
