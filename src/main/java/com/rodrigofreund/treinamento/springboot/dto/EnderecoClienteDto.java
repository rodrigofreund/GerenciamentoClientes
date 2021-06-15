package com.rodrigofreund.treinamento.springboot.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EnderecoClienteDto implements Serializable {

    private static final long serialVersionUID = -4457577821397859867L;
    
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private Long cep;
}
