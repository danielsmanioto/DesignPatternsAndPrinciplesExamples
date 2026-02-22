package com.visitor;

/**
 * Implementação concreta do Visitor: Calcula o total de impostos
 */
public class TaxVisitor implements ItemVisitor {
    
    private double totalTax = 0;
    
    @Override
    public void visit(Book book) {
        // Livros têm 0% de imposto (isenção)
        double tax = 0;
        System.out.printf("📚 %s - Imposto: R$ %.2f (0%%)%n", book.getTitle(), tax);
    }
    
    @Override
    public void visit(Food food) {
        // Alimentos têm 5% de imposto
        double tax = food.getPrice() * 0.05;
        totalTax += tax;
        System.out.printf("🍎 %s - Imposto: R$ %.2f (5%%)%n", food.getName(), tax);
    }
    
    @Override
    public void visit(Electronic electronic) {
        // Eletrônicos têm 15% de imposto
        double tax = electronic.getPrice() * 0.15;
        totalTax += tax;
        System.out.printf("💻 %s - Imposto: R$ %.2f (15%%)%n", electronic.getName(), tax);
    }
    
    public double getTotalTax() {
        return totalTax;
    }
}
