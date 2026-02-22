package com.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Playlist que implementa Iterable
 * Permite iterar em diferentes ordens
 */
public class Playlist implements Iterable {
    
    private final String name;
    private final List<Song> songs = new ArrayList<>();
    
    public Playlist(String name) {
        this.name = name;
    }
    
    /**
     * Adiciona uma música à playlist
     */
    public void addSong(Song song) {
        songs.add(song);
    }
    
    /**
     * Remove uma música da playlist
     */
    public void removeSong(Song song) {
        songs.remove(song);
    }
    
    /**
     * Retorna o número de músicas
     */
    public int getSize() {
        return songs.size();
    }
    
    /**
     * Retorna o nome da playlist
     */
    public String getName() {
        return name;
    }
    
    @Override
    public PlaylistIterator createIterator() {
        return new ForwardPlaylistIterator(songs);
    }
    
    /**
     * Cria um iterador reverso
     */
    public PlaylistIterator createReverseIterator() {
        return new ReversePlaylistIterator(songs);
    }
}
