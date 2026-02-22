package com.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação concreta do iterador para playlist reverso
 */
public class ReversePlaylistIterator implements PlaylistIterator {
    
    private final List<Song> songs;
    private int currentPosition;
    
    public ReversePlaylistIterator(List<Song> songs) {
        this.songs = new ArrayList<>(songs);
        this.currentPosition = songs.size() - 1;
    }
    
    @Override
    public boolean hasNext() {
        return currentPosition >= 0;
    }
    
    @Override
    public Song next() {
        if (!hasNext()) {
            throw new IllegalStateException("Não há próxima música");
        }
        return songs.get(currentPosition--);
    }
    
    @Override
    public void remove() {
        if (currentPosition == songs.size() - 1) {
            throw new IllegalStateException("Nenhuma música foi acessada");
        }
        songs.remove(currentPosition + 1);
    }
}
