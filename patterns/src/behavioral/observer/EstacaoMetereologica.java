package behavioral.observer;
import java.util.*;

class EstacaoMeteorologica implements Sujeito {
    private List<Observador> observadores;
    private float temperatura;
    private float humidade;
    private float pressao;
    
    public EstacaoMeteorologica() {
        this.observadores = new ArrayList<>();
        this.temperatura = 0;
        this.humidade = 0;
        this.pressao = 0;
    }
    
    public void definirMedidas(float temperatura, float humidade, float pressao) {
        // Só notifica se os dados realmente mudaram
        if (this.temperatura != temperatura || 
            this.humidade != humidade || 
            this.pressao != pressao) {
            
            this.temperatura = temperatura;
            this.humidade = humidade;
            this.pressao = pressao;
            
            System.out.println("\n--- dados actualizados ---");
            System.out.println("temperatura: " + temperatura + "°c");
            System.out.println("humidade: " + humidade + "%");
            System.out.println("pressão: " + pressao + " hpa");
            System.out.println("--------------------------\n");
            
            notificarObservadores();
        }
    }
    
    @Override
    public void registarObservador(Observador observador) {
        observadores.add(observador);
        System.out.println(observador.getClass().getSimpleName() + " registado na estação");
    }
    
    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
        System.out.println(observador.getClass().getSimpleName() + " removido da estação");
    }
    
    @Override
    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.atualizar(temperatura, humidade, pressao);
        }
    }
    
    // getters para dados actuais
    public float getTemperatura() {
        return temperatura;
    }
    
    public float getHumidade() {
        return humidade;
    }
    
    public float getPressao() {
        return pressao;
    }
    
    public int getNumeroObservadores() {
        return observadores.size();
    }
}
