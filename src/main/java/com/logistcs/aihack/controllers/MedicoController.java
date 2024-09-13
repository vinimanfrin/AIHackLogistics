package com.logistcs.aihack.controllers;

import com.logistcs.aihack.domain.enums.EspecialidadeMedico;
import com.logistcs.aihack.dtos.MedicoCreateDTO;
import com.logistcs.aihack.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping("/create")
    public String getFormularioDeCriacao(Model model){
        model.addAttribute("especialidades", EspecialidadeMedico.values());
        model.addAttribute("medicoCreateDTO", new MedicoCreateDTO());
        return "new-medico";
    }

    @PostMapping
    public String newMedico(@ModelAttribute MedicoCreateDTO medicoCreateDTO){
        service.newMedico(medicoCreateDTO);
        return "redirect:/";
    }
}
