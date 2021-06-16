package com.rodrigofreund.treinamento.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rodrigofreund.treinamento.springboot.dto.CadastroClienteDto;
import com.rodrigofreund.treinamento.springboot.dto.out.ClienteDto;
import com.rodrigofreund.treinamento.springboot.exception.ClienteExistenteException;
import com.rodrigofreund.treinamento.springboot.exception.ClienteInexistenteException;
import com.rodrigofreund.treinamento.springboot.repository.model.FiltroCliente;

public interface ClienteService {

    public Page<ClienteDto> findByCriteria(FiltroCliente filtroCliente, Pageable pageable);
    public Page<ClienteDto> buscarTodos(Pageable pageable);
    public boolean criarCliente(CadastroClienteDto dadosClienteDto) throws ClienteExistenteException;
    public boolean atualizarCliente(CadastroClienteDto dadosClienteDto) throws ClienteInexistenteException;
    
}
