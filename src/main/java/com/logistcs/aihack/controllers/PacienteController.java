package com.logistcs.aihack.controllers;

import com.logistcs.aihack.dtos.PacienteCreateDTO;
import com.logistcs.aihack.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public String getPacientes(Model model){
        model.addAttribute("pacientes",service.findAll());
        return "pacientes-list";
    }

    @GetMapping("/create")
    public String getFormularioDeCriacao(Model model) {
        model.addAttribute("pacienteCreateDTO", new PacienteCreateDTO());
        return "new-paciente";
    }

    @PostMapping
    public String newPaciente(@ModelAttribute @Valid PacienteCreateDTO pacienteCreateDTO){
        service.newPaciente(pacienteCreateDTO);
        return "redirect:/pacientes";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/pacientes";
    }
}
