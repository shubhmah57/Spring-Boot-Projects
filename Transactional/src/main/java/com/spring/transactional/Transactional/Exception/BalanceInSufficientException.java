package com.spring.transactional.Transactional.Exception;

public class BalanceInSufficientException extends RuntimeException{

    public BalanceInSufficientException(String message){
        super(message);
    }
}
