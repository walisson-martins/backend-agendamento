package com.api.agendamento.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponseDTO {

    private String mensagem;
    private Object data;

    public BaseResponseDTO(String mensagem, Object data) {
        this.mensagem = mensagem;
        this.data = data;
    }
}
