package com.rodrigofreund.treinamento.springboot.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rodrigofreund.treinamento.springboot.dto.CadastroClienteDto;
import com.rodrigofreund.treinamento.springboot.dto.out.ClienteDto;
import com.rodrigofreund.treinamento.springboot.model.EstadoCivil;
import com.rodrigofreund.treinamento.springboot.repository.model.Cliente;

@ExtendWith(MockitoExtension.class)
public class ClienteMapperTest {

    private ClienteMapper mapper;

    @BeforeEach
    void init() {
        mapper = new ClienteMapper();
    }

    @Test
    void convertToClienteTest() {
        CadastroClienteDto expected = CadastroClienteDto.builder()
                .cpf("51589369009")
                .dataNascimento(LocalDate.now().minusYears(30))
                .estadoCivil(EstadoCivil.CASADO)
                .nome("Gulado Duicuos di Vegath")
                .build();

        Cliente actual = mapper.convertToCliente(expected);

        assertThat(expected.getCpf()).isEqualTo(actual.getCpf());
        assertThat(expected.getDataNascimento()).isEqualTo(actual.getDataNascimento());
        assertThat(expected.getEstadoCivil()).isEqualTo(actual.getEstadoCivil());
        assertThat(expected.getNome()).isEqualTo(actual.getNome());
    }

    @Test
    void convertToClienteDtoTest() {

        Cliente expected = new Cliente("51589369009", "Gulado Duicuos di Vegath", LocalDate.now().minusYears(30),
                EstadoCivil.CASADO);

        ClienteDto actual = mapper.convertToClienteDto(expected);

        assertThat(expected.getCpf()).isEqualTo(actual.getCpf());
        assertThat(expected.getDataNascimento()).isEqualTo(actual.getDataNascimento());
        assertThat(expected.getEstadoCivil()).isEqualTo(actual.getEstadoCivil());
        assertThat(expected.getNome()).isEqualTo(actual.getNome());
    }
}
