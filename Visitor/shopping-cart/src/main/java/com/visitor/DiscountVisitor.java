package com.visitor;

/**
 * Implementação concreta do Visitor: Calcula o desconto
 */
public class DiscountVisitor implements ItemVisitor {
    
    private double totalDiscount = 0;
    
    @Override
    public void visit(Book book) {
        // Livros têm 10% de desconto
        double discount = book.getPrice() * 0.10;
        totalDiscount += discount;
        System.out.printf("📚 %s - Desconto: R$ %.2f (10%%)%n", book.getTitle(), discount);
    }
    
    @Override
    public void visit(Food food) {
        // Alimentos perecíveis têm 15% de desconto
        double discount = food.isPerishable() ? food.getPrice() * 0.15 : 0;
        totalDiscount += discount;
        System.out.printf("🍎 %s - Desconto: R$ %.2f%s%n", 
            food.getName(), discount, food.isPerishable() ? " (15% - Perecível)" : "");
    }
    
    @Override
    public void visit(Electronic electronic) {
        // Eletrônicos com garantia > 12 meses têm 5% de desconto
        double discount = electronic.getWarranty() > 12 ? electronic.getPrice() * 0.05 : 0;
        totalDiscount += discount;
        System.out.printf("💻 %s - Desconto: R$ %.2f%s%n", 
            electronic.getName(), discount, electronic.getWarranty() > 12 ? " (5% - Boa Garantia)" : "");
    }
    
    public double getTotalDiscount() {
        return totalDiscount;
    }
}
