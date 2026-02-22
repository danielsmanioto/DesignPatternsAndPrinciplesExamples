package com.mediator;

/**
 * Interface para o mediador
 * Define os métodos de comunicação entre aviões
 */
public interface AirTrafficControl {
    
    /**
     * Registra um avião na torre de controle
     */
    void registerAirplane(Airplane airplane);
    
    /**
     * Remove um avião da torre de controle
     */
    void unregisterAirplane(Airplane airplane);
    
    /**
     * Processa a solicitação de aterrissagem de um avião
     */
    void requestLanding(Airplane airplane);
    
    /**
     * Autoriza ou nega a aterrissagem de um avião
     */
    void approveLanding(Airplane airplane);
    
    /**
     * Notifica os aviões sobre mudanças de status
     */
    void notifyAirplanes(String message);
}
