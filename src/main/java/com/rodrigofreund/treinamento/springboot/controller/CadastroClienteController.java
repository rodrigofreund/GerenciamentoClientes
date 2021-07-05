package com.rodrigofreund.treinamento.springboot.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofreund.treinamento.springboot.dto.CadastroClienteDto;
import com.rodrigofreund.treinamento.springboot.dto.out.ClienteDto;
import com.rodrigofreund.treinamento.springboot.exception.ClienteExistenteException;
import com.rodrigofreund.treinamento.springboot.exception.ClienteInexistenteException;
import com.rodrigofreund.treinamento.springboot.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("Cadastro")
public final class CadastroClienteController {

    private ClienteService clienteService;

    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDto> cadastrarCliente(@Valid @RequestBody CadastroClienteDto dadosClienteDto)
            throws ClienteExistenteException {

        return ResponseEntity.ok(clienteService.criarCliente(dadosClienteDto));
    }

    @PostMapping(value = "/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDto> atualizarCliente(@Valid @RequestBody CadastroClienteDto dadosClienteDto)
            throws ClienteInexistenteException {

        return ResponseEntity.ok(clienteService.atualizarCliente(dadosClienteDto));
    }

}
