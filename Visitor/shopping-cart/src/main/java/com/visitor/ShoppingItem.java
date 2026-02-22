package com.visitor;

/**
 * Interface Element - Define o contrato para aceitar visitors
 */
public interface ShoppingItem {
    
    /**
     * Aceita um visitor
     */
    void accept(ItemVisitor visitor);
    
    /**
     * Retorna o preço do item
     */
    double getPrice();
    
    /**
     * Retorna o nome do item
     */
    String getName();
}
