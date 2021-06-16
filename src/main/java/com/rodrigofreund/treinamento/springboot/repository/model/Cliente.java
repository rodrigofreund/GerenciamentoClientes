package com.rodrigofreund.treinamento.springboot.repository.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rodrigofreund.treinamento.springboot.model.EstadoCivil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cliente")
public class Cliente {

    @Id
    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;
    private EstadoCivil estadoCivil;

}
