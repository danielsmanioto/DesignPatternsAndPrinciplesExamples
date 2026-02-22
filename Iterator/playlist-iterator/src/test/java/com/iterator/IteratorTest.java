package com.iterator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IteratorTest {
    
    private Playlist playlist;
    
    @Before
    public void setUp() {
        playlist = new Playlist("Test Playlist");
        playlist.addSong(new Song("Song 1", "Artist 1", 180));
        playlist.addSong(new Song("Song 2", "Artist 2", 200));
        playlist.addSong(new Song("Song 3", "Artist 3", 220));
    }
    
    @Test
    public void testForwardIteration() {
        var iterator = playlist.createIterator();
        
        assertTrue(iterator.hasNext());
        Song song1 = iterator.next();
        assertEquals("Song 1", song1.title());
        
        assertTrue(iterator.hasNext());
        Song song2 = iterator.next();
        assertEquals("Song 2", song2.title());
        
        assertTrue(iterator.hasNext());
        Song song3 = iterator.next();
        assertEquals("Song 3", song3.title());
        
        assertFalse(iterator.hasNext());
    }
    
    @Test
    public void testReverseIteration() {
        var iterator = playlist.createReverseIterator();
        
        assertTrue(iterator.hasNext());
        Song song3 = iterator.next();
        assertEquals("Song 3", song3.title());
        
        assertTrue(iterator.hasNext());
        Song song2 = iterator.next();
        assertEquals("Song 2", song2.title());
        
        assertTrue(iterator.hasNext());
        Song song1 = iterator.next();
        assertEquals("Song 1", song1.title());
        
        assertFalse(iterator.hasNext());
    }
    
    @Test
    public void testPlaylistSize() {
        assertEquals(3, playlist.getSize());
        
        playlist.addSong(new Song("Song 4", "Artist 4", 240));
        assertEquals(4, playlist.getSize());
    }
    
    @Test
    public void testRemoveSong() {
        Song song = new Song("Song 1", "Artist 1", 180);
        playlist.removeSong(song);
        assertEquals(2, playlist.getSize());
    }
    
    @Test(expected = IllegalStateException.class)
    public void testNextOnEmptyIterator() {
        var playlist = new Playlist("Empty");
        var iterator = playlist.createIterator();
        iterator.next();
    }
}
