package com.mediator;

/**
 * Interface para objetos que se comunicam via mediador
 */
public interface Colleague {
    
    /**
     * Envia uma mensagem através do mediador
     */
    void send(String message);
    
    /**
     * Recebe uma mensagem do mediador
     */
    void receive(String message);
}
