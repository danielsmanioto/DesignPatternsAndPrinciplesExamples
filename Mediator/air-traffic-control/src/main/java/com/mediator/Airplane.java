package com.mediator;

/**
 * Classe que representa um avião
 * Comunica-se através do mediador (Tower)
 */
public class Airplane implements Colleague {
    
    private final String id;
    private AirTrafficControl mediator;
    private Status status = Status.FLYING;
    
    public enum Status {
        FLYING("Voando"),
        WAITING("Aguardando"),
        LANDING("Pousando"),
        LANDED("Pousado");
        
        private final String description;
        Status(String description) {
            this.description = description;
        }
        public String getDescription() {
            return description;
        }
    }
    
    public Airplane(String id) {
        this.id = id;
    }
    
    public void setMediator(AirTrafficControl mediator) {
        this.mediator = mediator;
    }
    
    /**
     * O avião solicita permissão para pousar através do mediador
     */
    public void requestLanding() {
        if (mediator == null) {
            System.out.printf("❌ Avião %s não tem mediador%n", id);
            return;
        }
        status = Status.WAITING;
        System.out.printf("📡 Avião %s solicitando permissão para pousar...%n", id);
        mediator.requestLanding(this);
    }
    
    /**
     * O avião pousa (chamado pelo mediador)
     */
    public void land() {
        status = Status.LANDING;
        try {
            Thread.sleep(1000); // Simula o pouso
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        status = Status.LANDED;
        System.out.printf("🎉 Avião %s pousou com sucesso!%n", id);
    }
    
    @Override
    public void send(String message) {
        if (mediator != null) {
            System.out.printf("📡 Avião %s enviando: %s%n", id, message);
            mediator.notifyAirplanes(message);
        }
    }
    
    @Override
    public void receive(String message) {
        System.out.printf("📻 Avião %s recebeu: %s%n", id, message);
    }
    
    public String getId() {
        return id;
    }
    
    public Status getStatus() {
        return status;
    }
}
