package com.rodrigofreund.treinamento.springboot.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.rodrigofreund.treinamento.springboot.model.EstadoCivil;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public final class CriarClienteDto implements Serializable {

    private static final long serialVersionUID = -5087777149384707796L;

    private Long cpf;
    
    @NotBlank(message = "{cliente.cadastro.criar.nome-obrigatorio}")
    private String nomeComleto;
    
    private LocalDate dataNascimento;
    
    private EstadoCivil estadoCivil;
    
    private EnderecoClienteDto endereco;

}
