package com.rodrigofreund.treinamento.springboot.dto.out;

import java.io.Serializable;
import java.time.LocalDate;

import com.rodrigofreund.treinamento.springboot.model.EstadoCivil;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClienteDto implements Serializable {

    private static final long serialVersionUID = -2233379029199890619L;

    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Integer idade;
    private EstadoCivil estadoCivil;

}
