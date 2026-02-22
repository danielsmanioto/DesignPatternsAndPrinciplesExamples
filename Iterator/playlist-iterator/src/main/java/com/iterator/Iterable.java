package com.iterator;

/**
 * Interface que define uma coleção iterável
 */
public interface Iterable {
    
    /**
     * Cria um iterador para a coleção
     */
    PlaylistIterator createIterator();
}
