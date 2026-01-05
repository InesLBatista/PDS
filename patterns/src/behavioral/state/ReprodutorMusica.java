package behavioral.state;

import java.util.*;

class ReprodutorMusica {
    private EstadoReproducao estadoParado;
    private EstadoReproducao estadoReproduzindo;
    private EstadoReproducao estadoPausado;
    
    private EstadoReproducao estadoAtual;
    private List<String> faixas;
    private int faixaAtualIndex;
    
    public ReprodutorMusica(List<String> faixas) {
        this.faixas = new ArrayList<>(faixas);
        this.faixaAtualIndex = 0;
        
        // criar estados
        this.estadoParado = new EstadoParado(this);
        this.estadoReproduzindo = new EstadoReproduzindo(this);
        this.estadoPausado = new EstadoPausado(this);
        
        // estado inicial
        this.estadoAtual = estadoParado;
    }
    
    // métodos que delegam para o estado atual
    public void reproduzir() {
        estadoAtual.reproduzir();
    }
    
    public void pausar() {
        estadoAtual.pausar();
    }
    
    public void parar() {
        estadoAtual.parar();
    }
    
    public void proximaFaixa() {
        estadoAtual.proximaFaixa();
    }
    
    public void faixaAnterior() {
        estadoAtual.faixaAnterior();
    }
    
    // métodos internos usados pelos estados
    void setEstado(EstadoReproducao estado) {
        this.estadoAtual = estado;
        mostrarEstado();
    }
    
    void reproduzirFaixaAtual() {
        System.out.println("a reproduzir: " + getFaixaAtual());
    }
    
    void selecionarProximaFaixa() {
        if (faixaAtualIndex < faixas.size() - 1) {
            faixaAtualIndex++;
        } else {
            faixaAtualIndex = 0; // voltar ao início
        }
    }
    
    void selecionarFaixaAnterior() {
        if (faixaAtualIndex > 0) {
            faixaAtualIndex--;
        } else {
            faixaAtualIndex = faixas.size() - 1; // ir para o final
        }
    }
    
    // getters para estados
    EstadoReproducao getEstadoParado() {
        return estadoParado;
    }
    
    EstadoReproducao getEstadoReproduzindo() {
        return estadoReproduzindo;
    }
    
    EstadoReproducao getEstadoPausado() {
        return estadoPausado;
    }
    
    // getters para informação
    public String getFaixaAtual() {
        if (faixas.isEmpty()) {
            return "sem faixas";
        }
        return faixas.get(faixaAtualIndex);
    }
    
    public String getEstadoAtualNome() {
        return estadoAtual.getNomeEstado();
    }
    
    public void mostrarEstado() {
        System.out.println("estado: " + getEstadoAtualNome());
        System.out.println("faixa: " + getFaixaAtual());
        System.out.println("progresso: " + (faixaAtualIndex + 1) + "/" + faixas.size());
        System.out.println();
    }
}
