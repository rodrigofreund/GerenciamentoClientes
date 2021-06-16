package com.rodrigofreund.treinamento.springboot.exception;

import java.util.ResourceBundle;

public class BusinessException extends Exception {

    private static final long serialVersionUID = -5347333654312722643L;
    
    public BusinessException(String resourceMsg) {
        super(ResourceBundle.getBundle("messages").getString(resourceMsg));
    }

}
