package com.visitor;

/**
 * Elemento concreto: Livro
 */
public class Book implements ShoppingItem {
    
    private final String title;
    private final String author;
    private final double price;
    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String getName() {
        return title;
    }
    
    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return String.format("📚 %s por %s (R$ %.2f)", title, author, price);
    }
}
