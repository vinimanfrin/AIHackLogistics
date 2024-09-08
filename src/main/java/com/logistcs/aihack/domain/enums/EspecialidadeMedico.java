package com.logistcs.aihack.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EspecialidadeMedico {

    CARDIOLOGISTA(0),
    ORTOPEDISTA(1);

    private final int value;

    EspecialidadeMedico(int value){
        this.value = value;
    }

    @JsonValue
    public int getValue(){
        return value;
    }

    @JsonCreator
    public static EspecialidadeMedico especialidadeMedico(int value){
        for (EspecialidadeMedico especialidade : values()){
            if (especialidade.value == value){
                return especialidade;
            }
        }
        throw new IllegalArgumentException("Especialidade inválida: " + value);
    }
}
