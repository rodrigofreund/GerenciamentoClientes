package com.rodrigofreund.treinamento.springboot.dto.out;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import com.rodrigofreund.treinamento.springboot.model.EstadoCivil;

import lombok.Getter;

@Getter
public class ClienteDto implements Serializable {

    private static final long serialVersionUID = -2233379029199890619L;

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Integer idade;
    private EstadoCivil estadoCivil;
    
    public ClienteDto(String cpf, String nome, LocalDate dataNascimento, EstadoCivil estadoCivil) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.idade = Period.between(dataNascimento, LocalDate.now()).getYears();
    }

}
