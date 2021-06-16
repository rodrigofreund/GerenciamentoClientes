package com.rodrigofreund.treinamento.springboot;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rodrigofreund.treinamento.springboot.model.EstadoCivil;
import com.rodrigofreund.treinamento.springboot.repository.ClienteRepository;
import com.rodrigofreund.treinamento.springboot.repository.model.Cliente;
import com.rodrigofreund.treinamento.springboot.repository.model.FiltroCliente;
import com.rodrigofreund.treinamento.springboot.service.ClienteService;

@SpringBootTest
class ClienteServiceTest {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteRepository repository;

    @Test
    void findByCriteriaTest() {

        Cliente expected = criarClientes();

        FiltroCliente filtro = new FiltroCliente();
        filtro.setNome("Ana");
        
        Pageable pageable = Pageable.ofSize(10);

        Page<Cliente> result = clienteService.findByCriteria(filtro, pageable);

        assertThat(expected.equals(result.getContent().get(0)));

    }
    
    private Cliente criarClientes() {
        Cliente cliente = new Cliente(123l, "Ana", LocalDate.now(), EstadoCivil.CASADO);
        Stream.of(
                cliente,
                new Cliente(1234l, "Pedro", LocalDate.now(), EstadoCivil.CASADO),
                new Cliente(125l, "Ana Maria", LocalDate.now(), EstadoCivil.CASADO),
                new Cliente(126l, "Augusto", LocalDate.now(), EstadoCivil.CASADO)
                )
        .forEach(c -> repository.save(c));
        return cliente;
    }

}
