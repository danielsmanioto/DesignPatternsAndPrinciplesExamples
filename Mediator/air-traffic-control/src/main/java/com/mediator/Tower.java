package com.mediator;

import java.util.*;

/**
 * Implementação concreta do mediador
 * Torre de controle de tráfego aéreo
 */
public class Tower implements AirTrafficControl {
    
    private final String name;
    private final Set<Airplane> registeredAirplanes = new HashSet<>();
    private final Queue<Airplane> landingQueue = new LinkedList<>();
    private Airplane airplaneOnRunway = null;
    
    public Tower(String name) {
        this.name = name;
    }
    
    @Override
    public void registerAirplane(Airplane airplane) {
        if (registeredAirplanes.add(airplane)) {
            System.out.printf("✈️  Avião %s registrado na torre %s%n", airplane.getId(), name);
            airplane.setMediator(this);
        }
    }
    
    @Override
    public void unregisterAirplane(Airplane airplane) {
        registeredAirplanes.remove(airplane);
        System.out.printf("✈️  Avião %s removido da torre %s%n", airplane.getId(), name);
    }
    
    @Override
    public void requestLanding(Airplane airplane) {
        if (!registeredAirplanes.contains(airplane)) {
            System.out.printf("❌ Avião %s não registrado na torre%n", airplane.getId());
            return;
        }
        
        if (airplaneOnRunway == null) {
            approveLanding(airplane);
        } else {
            landingQueue.offer(airplane);
            System.out.printf("⏳ Avião %s adicionado à fila de aterrissagem (posição: %d)%n", 
                    airplane.getId(), landingQueue.size());
        }
    }
    
    @Override
    public void approveLanding(Airplane airplane) {
        if (airplaneOnRunway != null) {
            System.out.printf("❌ Pista ocupada! Avião %s em uso%n", airplaneOnRunway.getId());
            return;
        }
        
        airplaneOnRunway = airplane;
        System.out.printf("🛬 AUTORIZADO: Avião %s pode pousar na pista%n", airplane.getId());
        airplane.land();
        
        // Liberar a pista e autorizar próximo avião
        airplaneOnRunway = null;
        
        if (!landingQueue.isEmpty()) {
            Airplane nextAirplane = landingQueue.poll();
            System.out.printf("📢 Próximo avião chamado: %s%n", nextAirplane.getId());
            requestLanding(nextAirplane);
        }
    }
    
    @Override
    public void notifyAirplanes(String message) {
        System.out.printf("\n📢 BROADCAST da Torre %s: %s%n", name, message);
        for (Airplane airplane : registeredAirplanes) {
            airplane.receive(message);
        }
    }
    
    public int getQueueSize() {
        return landingQueue.size();
    }
    
    public boolean isRunwayFree() {
        return airplaneOnRunway == null;
    }
}
