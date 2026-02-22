package com.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory (Fabrica) que gerencia um pool de Flyweights.
 * Garante que caracteres iguais sejam reutilizados.
 */
public class CharacterFactory {
    
    private static final Map<String, Character> pool = new HashMap<>();
    private static int createdCount = 0;
    
    /**
     * Obtém um caractere do pool.
     * Se não existir, cria um novo e adiciona ao pool.
     */
    public static Character getCharacter(char value, String font, int size, String color) {
        String key = createKey(value, font, size, color);
        
        return pool.computeIfAbsent(key, k -> {
            createdCount++;
            System.out.printf("[NOVO] Criando caractere: %c (Total criados: %d)%n", value, createdCount);
            return new Character(value, font, size, color);
        });
    }
    
    /**
     * Cria uma chave única para o caractere
     */
    private static String createKey(char value, String font, int size, String color) {
        return String.format("%c|%s|%d|%s", value, font, size, color);
    }
    
    /**
     * Retorna o número de caracteres criados no pool
     */
    public static int getPoolSize() {
        return pool.size();
    }
    
    /**
     * Retorna o número total de caracteres criados
     */
    public static int getCreatedCount() {
        return createdCount;
    }
    
    /**
     * Limpa o pool
     */
    public static void clear() {
        pool.clear();
        createdCount = 0;
    }
}
