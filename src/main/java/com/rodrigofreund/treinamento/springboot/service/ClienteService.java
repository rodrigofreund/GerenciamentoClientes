package com.rodrigofreund.treinamento.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rodrigofreund.treinamento.springboot.dto.CadastroClienteDto;
import com.rodrigofreund.treinamento.springboot.dto.FiltroCliente;
import com.rodrigofreund.treinamento.springboot.dto.out.ClienteDto;
import com.rodrigofreund.treinamento.springboot.exception.ClienteExistenteException;
import com.rodrigofreund.treinamento.springboot.exception.ClienteInexistenteException;

public interface ClienteService {

    public Page<ClienteDto> findByCriteria(FiltroCliente filtroCliente, Pageable pageable);

    public ClienteDto criarCliente(CadastroClienteDto dadosClienteDto) throws ClienteExistenteException;

    public ClienteDto atualizarCliente(CadastroClienteDto dadosClienteDto) throws ClienteInexistenteException;

}
