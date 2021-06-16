package com.rodrigofreund.treinamento.springboot.exception;

public class ClienteInexistenteException extends BusinessException {

    private static final long serialVersionUID = 1717041551355766521L;

    public ClienteInexistenteException() {
        super("cliente.cadastro.criar.cliente-inexistente-exception-msg");
    }
}
