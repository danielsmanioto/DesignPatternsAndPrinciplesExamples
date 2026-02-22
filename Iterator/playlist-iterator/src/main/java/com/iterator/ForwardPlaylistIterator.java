package com.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação concreta do iterador para playlist forward
 */
public class ForwardPlaylistIterator implements PlaylistIterator {
    
    private final List<Song> songs;
    private int currentPosition = 0;
    
    public ForwardPlaylistIterator(List<Song> songs) {
        this.songs = new ArrayList<>(songs);
    }
    
    @Override
    public boolean hasNext() {
        return currentPosition < songs.size();
    }
    
    @Override
    public Song next() {
        if (!hasNext()) {
            throw new IllegalStateException("Não há próxima música");
        }
        return songs.get(currentPosition++);
    }
    
    @Override
    public void remove() {
        if (currentPosition == 0) {
            throw new IllegalStateException("Nenhuma música foi acessada");
        }
        songs.remove(--currentPosition);
    }
}
