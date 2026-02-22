package com.visitor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VisitorTest {
    
    private ShoppingCart cart;
    
    @Before
    public void setUp() {
        cart = new ShoppingCart();
    }
    
    @Test
    public void testAddItem() {
        var book = new Book("Test", "Author", 50.0);
        cart.addItem(book);
        assertEquals(1, cart.getItemCount());
    }
    
    @Test
    public void testCartTotal() {
        cart.addItem(new Book("Book", "Author", 100.0));
        cart.addItem(new Food("Food", 50.0, false));
        assertEquals(150.0, cart.getTotal(), 0.001);
    }
    
    @Test
    public void testTaxVisitorBooks() {
        var cart = new ShoppingCart();
        cart.addItem(new Book("Book", "Author", 100.0));
        
        var taxVisitor = new TaxVisitor();
        cart.accept(taxVisitor);
        assertEquals(0.0, taxVisitor.getTotalTax(), 0.001);
    }
    
    @Test
    public void testTaxVisitorFood() {
        cart.addItem(new Food("Food", 100.0, false));
        
        var taxVisitor = new TaxVisitor();
        cart.accept(taxVisitor);
        assertEquals(5.0, taxVisitor.getTotalTax(), 0.001);
    }
    
    @Test
    public void testTaxVisitorElectronics() {
        cart.addItem(new Electronic("Laptop", 1000.0, 12));
        
        var taxVisitor = new TaxVisitor();
        cart.accept(taxVisitor);
        assertEquals(150.0, taxVisitor.getTotalTax(), 0.001);
    }
    
    @Test
    public void testDiscountVisitorBooks() {
        cart.addItem(new Book("Book", "Author", 100.0));
        
        var discountVisitor = new DiscountVisitor();
        cart.accept(discountVisitor);
        assertEquals(10.0, discountVisitor.getTotalDiscount(), 0.001);
    }
    
    @Test
    public void testDiscountVisitorPerishableFood() {
        cart.addItem(new Food("Food", 100.0, true));
        
        var discountVisitor = new DiscountVisitor();
        cart.accept(discountVisitor);
        assertEquals(15.0, discountVisitor.getTotalDiscount(), 0.001);
    }
    
    @Test
    public void testComplexCart() {
        cart.addItem(new Book("Book", "Author", 100.0));
        cart.addItem(new Food("Food", 100.0, true));
        cart.addItem(new Electronic("Laptop", 1000.0, 24));
        
        assertEquals(1200.0, cart.getTotal(), 0.001);
        
        var taxVisitor = new TaxVisitor();
        cart.accept(taxVisitor);
        assertEquals(155.0, taxVisitor.getTotalTax(), 0.001);
    }
}
