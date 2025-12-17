package Praticas.lab13.XIII1;

import java.util.List;

// Classe ToShare estendida para suportar leitura de produtos via Strategy

public class ToShareEnhanced extends ToShare {
    
    public void loadProducts(ProductsReader reader) {
        if (reader != null) {
            List<Product> items = reader.getItems();
            for (Product p : items) {
                add(p);
            }
        }
    }
    
    public void loadFromFile(String filename) {
        // Primeiro criar o ficheiro
        createTestFile(filename);
        
        ProductsReader reader = new TextFileProductsReader(filename);
        loadProducts(reader);
    }
    
    private void createTestFile(String filename) {
        try (java.io.PrintWriter writer = new java.io.PrintWriter(filename)) {
            writer.println("Motorcycle\t900009\tBMW R1150R Boxer Naked Roadster Cinza ABS\t195");
            writer.println("Motorcycle\t900010\tHarley-Davidson Pan America 1250\t205");
            writer.println("Van\t970005\tJeep Grand Cherokee\t150");
            writer.println("Van\t970006\tAlfa Romeo AR6\t130");
            writer.println("Van\t980001\tGMC Safari\t130");
            writer.println("Van\t980002\tLancia Voyager\t120");
            writer.println("Car\t990000\tFord Maverick\t120");
            writer.println("Motorcycle\t990001\tDucati DesertX\t185");
            writer.println("Car\t990002\tMAZDA MX-5 Miata\t100");
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Erro ao criar ficheiro: " + e.getMessage());
        }
    }
}
