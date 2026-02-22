package com.flyweight;

/**
 * Classe Flyweight que representa um caractere compartilhado.
 * Contém apenas estado intrínseco (imutável).
 */
public final class Character {
    
    private final char value;
    private final String font;
    private final int size;
    private final String color;
    
    public Character(char value, String font, int size, String color) {
        this.value = value;
        this.font = font;
        this.size = size;
        this.color = color;
    }
    
    public char getValue() {
        return value;
    }
    
    public String getFont() {
        return font;
    }
    
    public int getSize() {
        return size;
    }
    
    public String getColor() {
        return color;
    }
    
    @Override
    public String toString() {
        return "Character{" +
                "value=" + value +
                ", font='" + font + '\'' +
                ", size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}
