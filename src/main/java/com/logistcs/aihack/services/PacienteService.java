package com.logistcs.aihack.services;

import com.logistcs.aihack.domain.entities.Endereco;
import com.logistcs.aihack.domain.entities.Paciente;
import com.logistcs.aihack.dtos.PacienteCreateDTO;
import com.logistcs.aihack.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private PacienteRepository repository;

    @Transactional
    public Paciente newPaciente(PacienteCreateDTO pacienteCreateDTO){
        Endereco endereco = enderecoService.newEndereco(pacienteCreateDTO.getEndereco());
        Paciente paciente = new Paciente(null, pacienteCreateDTO.getTelefone(), pacienteCreateDTO.getNome(),
                pacienteCreateDTO.getDataNascimento(), endereco);

        return repository.save(paciente);
    }
}
