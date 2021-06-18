package com.rodrigofreund.treinamento.springboot.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.rodrigofreund.treinamento.springboot.model.EstadoCivil;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@EqualsAndHashCode
public final class CadastroClienteDto implements Serializable {

    private static final long serialVersionUID = -5087777149384707796L;

    @Size(min = 11, max = 11, message = "{cliente.cadastro.criar.cpf-comprimento}")
    private String cpf;
    
    @NotBlank(message = "{cliente.cadastro.criar.nome-obrigatorio}")
    private String nome;
    
    @PastOrPresent
    @NotNull(message = "{cliente.cadastro.criar.datanascimento-obrigatorio}")
    private LocalDate dataNascimento;
    
    private EstadoCivil estadoCivil;

}
