package com.iterator;

/**
 * Classe que representa uma música
 */
public record Song(String title, String artist, int duration) {
    
    @Override
    public String toString() {
        return String.format("🎵 %s - %s (%d:%02d)", title, artist, duration / 60, duration % 60);
    }
}
