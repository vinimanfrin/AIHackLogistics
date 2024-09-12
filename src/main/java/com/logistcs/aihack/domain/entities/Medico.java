package com.logistcs.aihack.domain.entities;

import com.logistcs.aihack.domain.enums.EspecialidadeMedico;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String crm;

    @Enumerated(EnumType.ORDINAL)
    private EspecialidadeMedico especialidade;

    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medico")
    private List<Consulta> consultas;

    public Medico() {
    }

    public Medico(String telefone, EspecialidadeMedico especialidade, String crm, String name, Long id) {
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.crm = crm;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public EspecialidadeMedico getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EspecialidadeMedico especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(id, medico.id) && Objects.equals(name, medico.name) && Objects.equals(crm, medico.crm) && especialidade == medico.especialidade && Objects.equals(telefone, medico.telefone) && Objects.equals(endereco, medico.endereco) && Objects.equals(consultas, medico.consultas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, crm, especialidade, telefone, endereco, consultas);
    }
}
