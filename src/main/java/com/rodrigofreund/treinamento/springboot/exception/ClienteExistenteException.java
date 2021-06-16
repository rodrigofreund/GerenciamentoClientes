package com.rodrigofreund.treinamento.springboot.exception;

public class ClienteExistenteException extends BusinessException {

    private static final long serialVersionUID = 1717041551355766521L;

    public ClienteExistenteException() {
        super("cliente.cadastro.criar.cliente-existente-exception-msg");
    }
}
