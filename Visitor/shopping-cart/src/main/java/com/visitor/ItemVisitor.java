package com.visitor;

/**
 * Interface Visitor - Define operações que podem ser aplicadas aos elementos
 */
public interface ItemVisitor {
    
    /**
     * Visita um produto simples
     */
    void visit(Book book);
    
    /**
     * Visita um alimento
     */
    void visit(Food food);
    
    /**
     * Visita eletrônicos
     */
    void visit(Electronic electronic);
}
