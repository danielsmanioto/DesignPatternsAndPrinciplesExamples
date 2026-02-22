package com.visitor;

/**
 * Elemento concreto: Alimento
 */
public class Food implements ShoppingItem {
    
    private final String name;
    private final double price;
    private final boolean isPerishable;
    
    public Food(String name, double price, boolean isPerishable) {
        this.name = name;
        this.price = price;
        this.isPerishable = isPerishable;
    }
    
    public boolean isPerishable() {
        return isPerishable;
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
        String perishable = isPerishable ? " (PERECÍVEL)" : "";
        return String.format("🍎 %s (R$ %.2f)%s", name, price, perishable);
    }
}
