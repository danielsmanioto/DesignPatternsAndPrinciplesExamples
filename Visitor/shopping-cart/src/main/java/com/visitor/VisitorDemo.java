package com.visitor;

/**
 * Demonstração do padrão Visitor
 */
public class VisitorDemo {
    
    public static void main(String[] args) {
        System.out.println("=== CARRINHO DE COMPRAS COM PADRÃO VISITOR ===\n");
        
        // Criar carrinho e adicionar itens
        var cart = new ShoppingCart();
        
        cart.addItem(new Book("Clean Code", "Robert Martin", 89.90));
        cart.addItem(new Book("Design Patterns", "Gang of Four", 120.00));
        cart.addItem(new Food("Maçã", 5.50, true));
        cart.addItem(new Food("Pão", 8.00, true));
        cart.addItem(new Food("Sal", 3.00, false));
        cart.addItem(new Electronic("Laptop", 3500.00, 24));
        cart.addItem(new Electronic("Mouse", 150.00, 12));
        
        System.out.println("--- ITENS NO CARRINHO ---");
        for (var item : cart.getItems()) {
            System.out.println(item);
        }
        
        System.out.printf("\n💰 Total do carrinho: R$ %.2f%n\n", cart.getTotal());
        
        // Aplicar visitor de impostos
        System.out.println("--- CÁLCULO DE IMPOSTOS ---");
        var taxVisitor = new TaxVisitor();
        cart.accept(taxVisitor);
        System.out.printf("Total de impostos: R$ %.2f%n\n", taxVisitor.getTotalTax());
        
        // Aplicar visitor de descontos
        System.out.println("--- CÁLCULO DE DESCONTOS ---");
        var discountVisitor = new DiscountVisitor();
        cart.accept(discountVisitor);
        System.out.printf("Total de descontos: R$ %.2f%n\n", discountVisitor.getTotalDiscount());
        
        // Resumo final
        System.out.println("--- RESUMO ---");
        double subtotal = cart.getTotal();
        double taxes = taxVisitor.getTotalTax();
        double discounts = discountVisitor.getTotalDiscount();
        double total = subtotal + taxes - discounts;
        
        System.out.printf("Subtotal:  R$ %.2f%n", subtotal);
        System.out.printf("Impostos:  R$ %.2f%n", taxes);
        System.out.printf("Descontos: R$ %.2f%n", discounts);
        System.out.printf("TOTAL:     R$ %.2f%n", total);
    }
}
