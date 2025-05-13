package com.api.agendamento.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumSpecialty {

    CARDIOLOGIA,
    DERMATOLOGIA,
    PEDIATRIA,
    CLINICO_GERAL;

    @JsonCreator
    public static EnumSpecialty from(String value) {
        return EnumSpecialty.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String getValue() {
        return name();
    }
}
