package Praticas.lab11.ex1;
import java.util.ArrayList;
import java.util.List;

// Classe que representa um produto e implementa o Subject no padrão Observer
public class Produto {
    private static int contadorCodigo = 1;
    
    private int codigo;
    private String descricao;
    private double precoBase;
    private EstadoProduto estado;
    private double maiorLance;
    private Cliente licitadorAtual;
    private long tempoMaximoLeilao;
    private long tempoInicioLeilao;
    private List<Observador> observadores;

    public Produto(String descricao, double precoBase) {
        this.codigo = contadorCodigo++;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.estado = new EstadoStock();
        this.maiorLance = 0;
        this.observadores = new ArrayList<>();
        this.estado.gerirEstado(this);
    }

    // Métodos do padrão Observer para gerir observadores
    public void registarObservador(Observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
            System.out.println(observador.getNome() + " está a seguir o produto " + this.descricao);
        }
    }
    
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
        System.out.println(observador.getNome() + " deixou de seguir o produto " + this.descricao);
    }

    public void notificarObservadores(String mensagem) {
        for (Observador observador : observadores) {
            observador.atualizar(mensagem);
        }
    }

    public List<Observador> getObservadores() {
        return new ArrayList<>(observadores);
    }

    // Getters e Setters
    public double getMaiorLance() { return maiorLance; }
    public int getCodigo() { return codigo; }
    public String getDescricao() { return descricao; }
    public double getPrecoBase() { return precoBase; }
    public Cliente getLicitadorAtual() { return licitadorAtual; }
    public long getTempoMaximoLeilao() { return tempoMaximoLeilao; }
    public long getTempoInicioLeilao() { return tempoInicioLeilao; }
    public EstadoProduto getEstado() { return estado; }

    public void setEstado(EstadoProduto estado) {
        this.estado = estado;
        estado.gerirEstado(this);
    }

    public void setMaiorLance(double maiorLance) {
        this.maiorLance = maiorLance;
    }

    public void setLicitadorAtual(Cliente licitadorAtual) {
        this.licitadorAtual = licitadorAtual;
    }

    public void setTempoMaximoLeilao(long tempoMaximoLeilao) {
        this.tempoMaximoLeilao = tempoMaximoLeilao;
    }

    public void setTempoInicioLeilao(long tempoInicioLeilao) {
        this.tempoInicioLeilao = tempoInicioLeilao;
    }

    @Override
    public String toString() {
        return String.format("Produto %d: %s | Preço Base: %.2f | Estado: %s | Maior Lance: %.2f", 
                           codigo, descricao, precoBase, estado.getNomeEstado(), maiorLance);
    }
}