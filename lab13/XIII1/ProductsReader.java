package Praticas.lab13.XIII1;

import java.util.List;

// Interface Strategy para leitura de produtos de diferentes fontes
public interface ProductsReader {
    List<Product> getItems();  // Retorna lista de produtos
}