package com.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Carrinho de compras que pode aceitar visitors
 */
public class ShoppingCart {
    
    private final List<ShoppingItem> items = new ArrayList<>();
    
    /**
     * Adiciona um item ao carrinho
     */
    public void addItem(ShoppingItem item) {
        items.add(item);
    }
    
    /**
     * Remove um item do carrinho
     */
    public void removeItem(ShoppingItem item) {
        items.remove(item);
    }
    
    /**
     * Retorna o total do carrinho
     */
    public double getTotal() {
        return items.stream()
                .mapToDouble(ShoppingItem::getPrice)
                .sum();
    }
    
    /**
     * Aceita um visitor para processar todos os itens
     */
    public void accept(ItemVisitor visitor) {
        for (ShoppingItem item : items) {
            item.accept(visitor);
        }
    }
    
    /**
     * Retorna o número de itens
     */
    public int getItemCount() {
        return items.size();
    }
    
    /**
     * Retorna todos os itens
     */
    public List<ShoppingItem> getItems() {
        return new ArrayList<>(items);
    }
}
