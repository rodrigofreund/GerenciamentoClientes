package com.rodrigofreund.treinamento.springboot.repository.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class Cliente {

    @Id
    private Long cpf;
    private LocalDate dataNascimento;
    private String estadoCivil;
}
