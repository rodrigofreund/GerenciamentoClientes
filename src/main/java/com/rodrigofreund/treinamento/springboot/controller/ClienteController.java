package com.rodrigofreund.treinamento.springboot.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofreund.treinamento.springboot.dto.CriarClienteDto;
import com.rodrigofreund.treinamento.springboot.repository.ClienteRepository;
import com.rodrigofreund.treinamento.springboot.repository.model.Cliente;

@RestController
@RequestMapping("Cadastro")
public final class ClienteController {
    
    
    private ClienteRepository repository;
    private ModelMapper dtoToDatabaseMapper;
    
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
        this.dtoToDatabaseMapper = new ModelMapper();
    }

    
    @PostMapping(value="/novo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> cadastrarCliente(@Valid @RequestBody CriarClienteDto dadosClienteDto) {
        System.out.println(dadosClienteDto);
        
        repository.save(dtoToDatabaseMapper.map(dadosClienteDto, Cliente.class));
        
        return ResponseEntity.ok("Ok");
    }
        
}
