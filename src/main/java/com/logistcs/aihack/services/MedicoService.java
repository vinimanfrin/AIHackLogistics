package com.logistcs.aihack.services;

import com.logistcs.aihack.domain.entities.Medico;
import com.logistcs.aihack.domain.enums.EspecialidadeMedico;
import com.logistcs.aihack.dtos.MedicoCreateDTO;
import com.logistcs.aihack.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public Medico newMedico(MedicoCreateDTO medicoCreateDTO){
        Medico medico = new Medico(medicoCreateDTO.getTelefone(),
                EspecialidadeMedico.especialidadeMedico(medicoCreateDTO.getEspecialidade()), medicoCreateDTO.getCrm(), medicoCreateDTO.getNome(), null);

        return repository.save(medico);
    }
}
