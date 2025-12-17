package Praticas.lab05.Exercício1;

import java.util.*;

public class Rental {
    // Classe que representa a empresa de aluguer de veículos
    private String nome;
    private String codPostal;
    private String email;
    private List<Veiculo> stock;

    public Rental(String nome, String codPostal, String email) {
        this.nome = nome;
        this.codPostal = codPostal;
        this.email = email;
        this.stock = new ArrayList<>();
    }

    public void addVeiculo(Veiculo v) {
        stock.add(v);
    }

    public List<Veiculo> getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Rental [nome=" + nome + ", codPostal=" + codPostal + ", email=" + email + "]";
    }
}

