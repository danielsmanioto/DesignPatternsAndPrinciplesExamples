package com.iterator;

/**
 * Demonstração do padrão Iterator
 */
public class IteratorDemo {
    
    public static void main(String[] args) {
        // Criando uma playlist
        var playlist = new Playlist("Rock Hits 2024");
        
        playlist.addSong(new Song("Bohemian Rhapsody", "Queen", 354));
        playlist.addSong(new Song("Stairway to Heaven", "Led Zeppelin", 482));
        playlist.addSong(new Song("Imagine", "John Lennon", 183));
        playlist.addSong(new Song("Hey Jude", "The Beatles", 427));
        
        System.out.println("=== ITERAÇÃO FORWARD ===\n");
        playForward(playlist);
        
        System.out.println("\n=== ITERAÇÃO REVERSA ===\n");
        playReverse(playlist);
        
        System.out.println("\n📊 Total de músicas: " + playlist.getSize());
    }
    
    private static void playForward(Playlist playlist) {
        var iterator = playlist.createIterator();
        int position = 1;
        
        while (iterator.hasNext()) {
            Song song = iterator.next();
            System.out.printf("%d. %s%n", position++, song);
        }
    }
    
    private static void playReverse(Playlist playlist) {
        var iterator = playlist.createReverseIterator();
        int position = 1;
        
        while (iterator.hasNext()) {
            Song song = iterator.next();
            System.out.printf("%d. %s%n", position++, song);
        }
    }
}
