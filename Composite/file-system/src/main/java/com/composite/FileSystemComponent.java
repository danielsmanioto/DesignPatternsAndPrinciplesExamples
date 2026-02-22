package com.composite;

/**
 * Componente abstrato para o padrão Composite.
 * Define a interface comum para arquivos e diretórios.
 */
public sealed interface FileSystemComponent permits File, Directory {
    
    /**
     * Retorna o nome do componente
     */
    String getName();
    
    /**
     * Retorna o tamanho do componente em bytes
     */
    long getSize();
    
    /**
     * Exibe a estrutura hierárquica do componente
     */
    void display(int depth);
}
