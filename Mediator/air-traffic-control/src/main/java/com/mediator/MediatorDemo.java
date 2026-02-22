package com.mediator;

/**
 * Demonstração do padrão Mediator
 */
public class MediatorDemo {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== TORRE DE CONTROLE DE TRÁFEGO AÉREO ===\n");
        
        // Criar a torre (mediador)
        var tower = new Tower("Aeroporto Internacional");
        
        // Criar aviões (colleagues)
        var airplane1 = new Airplane("AA100");
        var airplane2 = new Airplane("UA200");
        var airplane3 = new Airplane("DL300");
        var airplane4 = new Airplane("BA400");
        
        // Registrar aviões na torre
        tower.registerAirplane(airplane1);
        tower.registerAirplane(airplane2);
        tower.registerAirplane(airplane3);
        tower.registerAirplane(airplane4);
        
        System.out.println("\n--- SOLICITAÇÕES DE ATERRISSAGEM ---\n");
        
        // Aviões solicitam permissão para pousar
        airplane1.requestLanding();
        Thread.sleep(500);
        
        airplane2.requestLanding();
        Thread.sleep(500);
        
        airplane3.requestLanding();
        Thread.sleep(500);
        
        airplane4.requestLanding();
        Thread.sleep(3000);
        
        System.out.println("\n--- BROADCAST ---");
        tower.notifyAirplanes("Atenção! Turbulência na região. Permaneçam atentos!");
        
        System.out.println("\n--- STATUS FINAL ---");
        System.out.printf("Pista livre: %s%n", tower.isRunwayFree());
        System.out.printf("Aviões aguardando: %d%n", tower.getQueueSize());
    }
}
