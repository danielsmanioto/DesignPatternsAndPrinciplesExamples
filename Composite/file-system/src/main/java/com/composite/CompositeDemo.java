package com.composite;

/**
 * Demonstração do padrão Composite
 */
public class CompositeDemo {
    
    public static void main(String[] args) {
        // Criando a estrutura de diretórios
        var root = new Directory("root");
        
        var documents = new Directory("Documents");
        var pictures = new Directory("Pictures");
        var downloads = new Directory("Downloads");
        
        // Adicionando diretórios ao root
        root.add(documents);
        root.add(pictures);
        root.add(downloads);
        
        // Adicionando arquivos e subdiretórios
        documents.add(new File("report.pdf", 2048));
        documents.add(new File("presentation.pptx", 5120));
        
        var work = new Directory("Work");
        work.add(new File("project.txt", 512));
        work.add(new File("notes.docx", 1024));
        documents.add(work);
        
        pictures.add(new File("vacation.jpg", 3072));
        pictures.add(new File("family.png", 4096));
        
        downloads.add(new File("installer.exe", 50000));
        
        // Exibindo a estrutura
        System.out.println("=== ESTRUTURA DO SISTEMA DE ARQUIVOS ===\n");
        root.display(0);
        
        System.out.println("\n=== INFORMAÇÕES ===");
        System.out.printf("Tamanho total: %d bytes%n", root.getSize());
        System.out.printf("Tamanho de Documents: %d bytes%n", documents.getSize());
        System.out.printf("Tamanho de Pictures: %d bytes%n", pictures.getSize());
    }
}
