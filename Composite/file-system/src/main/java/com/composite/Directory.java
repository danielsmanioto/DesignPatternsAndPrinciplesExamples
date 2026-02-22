package com.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um diretório no padrão Composite.
 * Pode conter arquivos e outros diretórios (é uma composição).
 */
public final class Directory implements FileSystemComponent {
    
    private final String name;
    private final List<FileSystemComponent> children = new ArrayList<>();
    
    public Directory(String name) {
        this.name = name;
    }
    
    /**
     * Adiciona um componente (arquivo ou diretório) ao diretório
     */
    public void add(FileSystemComponent component) {
        children.add(component);
    }
    
    /**
     * Remove um componente do diretório
     */
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }
    
    /**
     * Retorna todos os componentes filhos
     */
    public List<FileSystemComponent> getChildren() {
        return new ArrayList<>(children);
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public long getSize() {
        return children.stream()
                .mapToLong(FileSystemComponent::getSize)
                .sum();
    }
    
    @Override
    public void display(int depth) {
        String indent = "  ".repeat(depth);
        System.out.printf("%s📁 %s/ (total: %d bytes)%n", indent, name, getSize());
        
        for (FileSystemComponent child : children) {
            child.display(depth + 1);
        }
    }
}
