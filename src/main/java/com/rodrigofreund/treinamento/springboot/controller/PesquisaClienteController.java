package com.rodrigofreund.treinamento.springboot.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofreund.treinamento.springboot.dto.out.ClienteDto;
import com.rodrigofreund.treinamento.springboot.mapper.ClienteMapper;
import com.rodrigofreund.treinamento.springboot.repository.model.FiltroCliente;
import com.rodrigofreund.treinamento.springboot.service.ClienteService;

@RestController
@RequestMapping("Pesquisa")
public final class PesquisaClienteController {
    
    private ClienteService service;
    
    public PesquisaClienteController(ClienteService service, ClienteMapper clienteMapper) {
        this.service = service;
    }
    
    @GetMapping(value="/pesquisar")
    public ResponseEntity<Page<ClienteDto>> pesquisar(FiltroCliente filtroCliente, Pageable pageable) {
        
        Page<ClienteDto> page = service.findByCriteria(filtroCliente, pageable);
        
        return ResponseEntity.ok(page);
    }

}
