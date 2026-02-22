package com.composite;

/**
 * Classe que representa um arquivo no padrão Composite.
 * É uma folha da árvore (não contém outros componentes).
 */
public final class File implements FileSystemComponent {
    
    private final String name;
    private final long size;
    
    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public long getSize() {
        return size;
    }
    
    @Override
    public void display(int depth) {
        String indent = "  ".repeat(depth);
        System.out.printf("%s📄 %s (%d bytes)%n", indent, name, size);
    }
}
