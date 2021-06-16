package com.rodrigofreund.treinamento.springboot.mapper;

import org.springframework.stereotype.Component;

import com.rodrigofreund.treinamento.springboot.dto.CadastroClienteDto;
import com.rodrigofreund.treinamento.springboot.dto.out.ClienteDto;
import com.rodrigofreund.treinamento.springboot.repository.model.Cliente;

@Component
public class ClienteMapper {

    public Cliente convertToCliente(CadastroClienteDto dto) {
        return new Cliente(dto.getCpf(), dto.getNomeComleto(), dto.getDataNascimento(), dto.getEstadoCivil());
    }
    
    public ClienteDto convertToClienteDto(Cliente cliente, Integer idade) {
        return ClienteDto.builder()
                .cpf(cliente.getCpf())
                .dataNascimento(cliente.getDataNascimento())
                .estadoCivil(cliente.getEstadoCivil())
                .nome(cliente.getNome())
                .idade(idade)
                .build();
    }
}
