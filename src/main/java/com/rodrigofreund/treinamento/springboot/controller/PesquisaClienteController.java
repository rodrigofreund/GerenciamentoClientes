package com.rodrigofreund.treinamento.springboot.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofreund.treinamento.springboot.dto.FiltroCliente;
import com.rodrigofreund.treinamento.springboot.dto.out.ClienteDto;
import com.rodrigofreund.treinamento.springboot.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("Pesquisa")
public final class PesquisaClienteController {

    private ClienteService service;

    @GetMapping(value = "/pesquisar")
    public ResponseEntity<Page<ClienteDto>> pesquisar(FiltroCliente filtroCliente, Pageable pageable) {

        Page<ClienteDto> page = service.findByCriteria(filtroCliente, pageable);

        return ResponseEntity.ok(page);
    }

}
