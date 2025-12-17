package Praticas.lab13.XIII1;

// Classe que representa um cliente da ToShare
public class Client {
    private String number;  // Número identificador do cliente
    private String name;    // Nome do cliente
    
    public Client(String number, String name) {
        this.number = number;
        this.name = name;
    }
    
    public String getNumber() {
        return number;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Client [number=" + number + ", name=" + name + "]";
    }
}