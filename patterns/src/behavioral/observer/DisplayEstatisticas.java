package behavioral.observer;
import java.util.*;

class DisplayEstatisticas implements Observador {
    private List<Float> temperaturas;
    private List<Float> humidades;
    private String nome;
    
    public DisplayEstatisticas(String nome) {
        this.nome = nome;
        this.temperaturas = new ArrayList<>();
        this.humidades = new ArrayList<>();
        System.out.println("display de estatísticas criado: " + nome);
    }
    
    @Override
    public void atualizar(float temperatura, float humidade, float pressao) {
        temperaturas.add(temperatura);
        humidades.add(humidade);
        exibir();
    }
    
    private void exibir() {
        if (temperaturas.isEmpty()) return;
        
        System.out.println("[" + nome + "] estatísticas:");
        System.out.println("  temperatura:");
        System.out.println("    actual: " + temperaturas.get(temperaturas.size() - 1) + "°c");
        System.out.println("    média: " + calcularMedia(temperaturas) + "°c");
        System.out.println("    máxima: " + calcularMaxima(temperaturas) + "°c");
        System.out.println("    mínima: " + calcularMinima(temperaturas) + "°c");
        
        System.out.println("  humidade:");
        System.out.println("    actual: " + humidades.get(humidades.size() - 1) + "%");
        System.out.println("    média: " + calcularMedia(humidades) + "%");
        System.out.println("  total de leituras: " + temperaturas.size());
        System.out.println();
    }
    
    private float calcularMedia(List<Float> valores) {
        float soma = 0;
        for (float valor : valores) {
            soma += valor;
        }
        return valores.size() > 0 ? soma / valores.size() : 0;
    }
    
    private float calcularMaxima(List<Float> valores) {
        float maxima = Float.MIN_VALUE;
        for (float valor : valores) {
            if (valor > maxima) maxima = valor;
        }
        return maxima;
    }
    
    private float calcularMinima(List<Float> valores) {
        float minima = Float.MAX_VALUE;
        for (float valor : valores) {
            if (valor < minima) minima = valor;
        }
        return minima;
    }
}
