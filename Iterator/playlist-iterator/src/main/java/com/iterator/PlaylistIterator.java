package com.iterator;

/**
 * Interface para o iterador personalizado
 */
public interface PlaylistIterator {
    
    /**
     * Verifica se há próximo elemento
     */
    boolean hasNext();
    
    /**
     * Retorna o próximo elemento
     */
    Song next();
    
    /**
     * Remove o elemento atual
     */
    void remove();
}
