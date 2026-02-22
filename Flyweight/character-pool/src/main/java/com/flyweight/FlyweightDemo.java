package com.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstração do padrão Flyweight
 */
public class FlyweightDemo {
    
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DO PADRÃO FLYWEIGHT ===\n");
        
        List<CharacterPosition> document = new ArrayList<>();
        
        // Adicionando caracteres ao documento
        // Observe que muitos caracteres são iguais (reutilizados do pool)
        String text = "Hello Hello Hello";
        int row = 0;
        int column = 0;
        
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                column += 5;
                continue;
            }
            
            Character character = CharacterFactory.getCharacter(c, "Arial", 12, "Black");
            document.add(new CharacterPosition(character, row, column));
            column += 10;
        }
        
        System.out.println("\n=== INFORMAÇÕES DO POOL ===");
        System.out.printf("Caracteres únicos no pool: %d%n", CharacterFactory.getPoolSize());
        System.out.printf("Caracteres criados: %d%n", CharacterFactory.getCreatedCount());
        System.out.printf("Caracteres no documento: %d%n", document.size());
        
        System.out.println("\n=== CONTEÚDO DO DOCUMENTO ===");
        document.forEach(System.out::println);
        
        System.out.printf("\n💾 Economia de memória: %d caracteres usando apenas %d objetos!%n",
                document.size(), CharacterFactory.getPoolSize());
    }
}
