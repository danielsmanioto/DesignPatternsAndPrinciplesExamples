package com.flyweight;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlyweightTest {
    
    @Before
    public void setUp() {
        CharacterFactory.clear();
    }
    
    @Test
    public void testCharacterCreation() {
        Character c = CharacterFactory.getCharacter('A', "Arial", 12, "Black");
        assertEquals('A', c.getValue());
        assertEquals("Arial", c.getFont());
        assertEquals(12, c.getSize());
        assertEquals("Black", c.getColor());
    }
    
    @Test
    public void testCharacterReuse() {
        Character c1 = CharacterFactory.getCharacter('A', "Arial", 12, "Black");
        Character c2 = CharacterFactory.getCharacter('A', "Arial", 12, "Black");
        
        // Deve ser o mesmo objeto
        assertSame(c1, c2);
        assertEquals(1, CharacterFactory.getPoolSize());
    }
    
    @Test
    public void testDifferentCharacters() {
        Character a = CharacterFactory.getCharacter('A', "Arial", 12, "Black");
        Character b = CharacterFactory.getCharacter('B', "Arial", 12, "Black");
        
        // Devem ser objetos diferentes
        assertNotSame(a, b);
        assertEquals(2, CharacterFactory.getPoolSize());
    }
    
    @Test
    public void testDifferentProperties() {
        Character c1 = CharacterFactory.getCharacter('A', "Arial", 12, "Black");
        Character c2 = CharacterFactory.getCharacter('A', "Courier", 12, "Black");
        Character c3 = CharacterFactory.getCharacter('A', "Arial", 14, "Black");
        Character c4 = CharacterFactory.getCharacter('A', "Arial", 12, "Red");
        
        assertEquals(4, CharacterFactory.getPoolSize());
    }
    
    @Test
    public void testCharacterPosition() {
        Character c = CharacterFactory.getCharacter('A', "Arial", 12, "Black");
        CharacterPosition pos = new CharacterPosition(c, 5, 10);
        
        assertEquals(5, pos.getRow());
        assertEquals(10, pos.getColumn());
        assertSame(c, pos.getCharacter());
    }
    
    @Test
    public void testMemorySaving() {
        // Adicionando vários caracteres iguais
        for (int i = 0; i < 100; i++) {
            CharacterFactory.getCharacter('A', "Arial", 12, "Black");
        }
        
        // Mas apenas 1 foi criado
        assertEquals(1, CharacterFactory.getCreatedCount());
        assertEquals(1, CharacterFactory.getPoolSize());
    }
}
