package com.flyweight;

/**
 * Classe que representa um caractere com posição (estado extrínseco).
 * Usa Flyweight para o estado compartilhado.
 */
public class CharacterPosition {
    
    private final Character character;
    private final int row;
    private final int column;
    
    public CharacterPosition(Character character, int row, int column) {
        this.character = character;
        this.row = row;
        this.column = column;
    }
    
    public Character getCharacter() {
        return character;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getColumn() {
        return column;
    }
    
    @Override
    public String toString() {
        return String.format("Pos(%d,%d): %c [%s, %d, %s]",
                row, column,
                character.getValue(),
                character.getFont(),
                character.getSize(),
                character.getColor());
    }
}
