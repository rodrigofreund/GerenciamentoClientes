package com.rodrigofreund.treinamento.springboot.repository.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.rodrigofreund.treinamento.springboot.model.EstadoCivil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class Cliente {

    @Id
    private String cpf;
    @Setter
    private String nome;
    @Setter
    private LocalDate dataNascimento;
    @Setter
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    
    public Cliente(String cpf, String nome, LocalDate dataNascimento, EstadoCivil estadoCivil) {
         this.cpf = cpf;
         this.nome = nome;
         this.dataNascimento = dataNascimento;
         this.estadoCivil = estadoCivil;
    }
    
    @PrePersist
    private void onCreate() {
        dataCriacao = LocalDateTime.now();
    }
    
    @PreUpdate
    private void onUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }

}
