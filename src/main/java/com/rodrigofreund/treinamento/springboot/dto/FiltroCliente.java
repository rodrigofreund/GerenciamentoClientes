package com.rodrigofreund.treinamento.springboot.dto;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import com.rodrigofreund.treinamento.springboot.model.EstadoCivil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class FiltroCliente {

    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;
    private EstadoCivil estadoCivil;
    
    public boolean pesquisaPorCpf() {
        return null != cpf;
    }
    
    public boolean pesquisaPorNome() {
        return StringUtils.isNotBlank(nome);
    }
    
    public boolean pesquisaPorDataNascimento() {
        return (null != dataNascimento);
    }
    
    public boolean pesquisaPorEstadoCivil() {
        return (null != estadoCivil);
    }
}
