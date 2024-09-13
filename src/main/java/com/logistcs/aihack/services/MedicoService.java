package com.logistcs.aihack.services;

import com.logistcs.aihack.domain.entities.Endereco;
import com.logistcs.aihack.domain.entities.Medico;
import com.logistcs.aihack.domain.enums.EspecialidadeMedico;
import com.logistcs.aihack.dtos.MedicoCreateDTO;
import com.logistcs.aihack.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private EnderecoService enderecoService;


    @Transactional
    public Medico newMedico(MedicoCreateDTO medicoCreateDTO){
        Endereco endereco = enderecoService.newEndereco(medicoCreateDTO.getEndereco());
        Medico medico = new Medico(null, medicoCreateDTO.getNome(), medicoCreateDTO.getCrm(), EspecialidadeMedico.especialidadeMedico(medicoCreateDTO.getEspecialidade()),
                medicoCreateDTO.getTelefone(), endereco);

        return repository.save(medico);
    }

    public List<Medico> findAll(){
        return repository.findAll();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
