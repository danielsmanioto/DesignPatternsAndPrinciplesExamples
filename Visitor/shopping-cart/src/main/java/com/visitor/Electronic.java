package com.visitor;

/**
 * Elemento concreto: Eletrônicos
 */
public class Electronic implements ShoppingItem {
    
    private final String name;
    private final double price;
    private final int warranty; // em meses
    
    public Electronic(String name, double price, int warranty) {
        this.name = name;
        this.price = price;
        this.warranty = warranty;
    }
    
    public int getWarranty() {
        return warranty;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return String.format("💻 %s (R$ %.2f - Garantia: %d meses)", name, price, warranty);
    }
}
