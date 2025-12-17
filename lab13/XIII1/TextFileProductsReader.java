package Praticas.lab13.XIII1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileProductsReader implements ProductsReader {
    private String filename;
    
    public TextFileProductsReader(String filename) {
        this.filename = filename;
    }
    
    @Override
    public List<Product> getItems() {
        List<Product> products = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                
                String[] parts = line.split("\t");
                if (parts.length >= 4) {
                    String type = parts[0];
                    String code = parts[1];
                    String description = parts[2];
                    double points = Double.parseDouble(parts[3]);
                    
                    Product product = createProduct(type, code, description, points);
                    if (product != null) {
                        products.add(product);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler ficheiro: " + e.getMessage());
        }
        
        return products;
    }
    
    private Product createProduct(String type, String code, String description, double points) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car(code, description, points);
            case "van":
                return new Van(code, description, points);
            case "motorcycle":
                return new Motorcycle(code, description, points);
            default:
                System.err.println("Tipo desconhecido: " + type);
                return null;
        }
    }
}