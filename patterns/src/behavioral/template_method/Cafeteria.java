package behavioral.template_method;

// Cafeteria.java - Cliente principal
public class Cafeteria {
    
    public static void main(String[] args) {
        System.out.println("=== Sistema de Preparacao de Bebidas Quentes ===\n");
        
        System.out.println("--- Preparando Cafe ---");
        BebidaQuenteTemplate cafe = new Cafe();
        cafe.prepararBebida();
        
        System.out.println("\n--- Preparando Cha ---");
        BebidaQuenteTemplate cha = new Cha();
        cha.prepararBebida();
        
        System.out.println("\n--- Preparando Chocolate Quente ---");
        BebidaQuenteTemplate chocolate = new ChocolateQuente();
        chocolate.prepararBebida();
        
        System.out.println("\n--- Preparando Cappuccino ---");
        BebidaQuenteTemplate cappuccino = new Cappuccino();
        cappuccino.prepararBebida();
        
        System.out.println("\n--- Preparando Cha Verde ---");
        BebidaQuenteTemplate chaVerde = new ChaVerde();
        chaVerde.prepararBebida();
        
        System.out.println("\n=== Demonstracao do Padrao Template Method ===");
        demonstrarProcesso();
    }
    
    private static void demonstrarProcesso() {
        System.out.println("\nProcesso padronizado para todas as bebidas:");
        System.out.println("1. Aquecer agua (especifico para cada bebida)");
        System.out.println("2. Adicionar ingrediente principal (especifico)");
        System.out.println("3. Mexer (especifico)");
        System.out.println("4. Adicionar condimentos (opcional, hook)");
        System.out.println("5. Servir (comum ou personalizado)");
    }
}