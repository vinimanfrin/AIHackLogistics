package com.logistcs.aihack.services;

import com.logistcs.aihack.domain.entities.Endereco;
import com.logistcs.aihack.dtos.EnderecoCreateDTO;
import com.logistcs.aihack.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco newEndereco(EnderecoCreateDTO enderecoCreateDTO){
        return repository.save(new Endereco(enderecoCreateDTO));
    }
}
