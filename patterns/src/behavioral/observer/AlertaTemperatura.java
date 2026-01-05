package behavioral.observer;

class AlertaTemperatura implements Observador {
    private float limiteSuperior;
    private float limiteInferior;
    private String nome;
    
    public AlertaTemperatura(String nome, float limiteInferior, float limiteSuperior) {
        this.nome = nome;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        System.out.println("sistema de alerta criado: " + nome + 
                         " (" + limiteInferior + "°c a " + limiteSuperior + "°c)");
    }
    
    @Override
    public void atualizar(float temperatura, float humidade, float pressao) {
        verificarAlertas(temperatura);
    }
    
    private void verificarAlertas(float temperatura) {
        if (temperatura > limiteSuperior) {
            System.out.println("[" + nome + "] alerta: temperatura alta!");
            System.out.println("    temperatura actual: " + temperatura + "°c");
            System.out.println("    limite superior: " + limiteSuperior + "°c");
            System.out.println("    diferença: +" + (temperatura - limiteSuperior) + "°c");
            System.out.println();
        } else if (temperatura < limiteInferior) {
            System.out.println("[" + nome + "] alerta: temperatura baixa!");
            System.out.println("    temperatura actual: " + temperatura + "°c");
            System.out.println("    limite inferior: " + limiteInferior + "°c");
            System.out.println("    diferença: " + (temperatura - limiteInferior) + "°c");
            System.out.println();
        }
    }
}