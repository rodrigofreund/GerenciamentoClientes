package com.rodrigofreund.treinamento.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rodrigofreund.treinamento.springboot.model.EstadoCivil;
import com.rodrigofreund.treinamento.springboot.repository.ClienteRepository;
import com.rodrigofreund.treinamento.springboot.repository.model.Cliente;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository repository;

    @Test
    public void findById() {

        Cliente expected = new Cliente("6165156", "Ana", LocalDate.now(), EstadoCivil.CASADO);
        repository.save(expected);

        Cliente actual = repository.findById("6165156").orElseThrow(() -> new RuntimeException("Not found"));

        assertEquals(expected.getCpf(), actual.getCpf());

    }

}
