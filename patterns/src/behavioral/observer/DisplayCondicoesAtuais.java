package behavioral.observer;

class DisplayCondicoesAtuais implements Observador {
    private float temperatura;
    private float humidade;
    private String nome;
    
    public DisplayCondicoesAtuais(String nome) {
        this.nome = nome;
        System.out.println("display de condições actuais criado: " + nome);
    }
    
    @Override
    public void atualizar(float temperatura, float humidade, float pressao) {
        this.temperatura = temperatura;
        this.humidade = humidade;
        exibir();
    }
    
    private void exibir() {
        System.out.println("[" + nome + "] condições actuais:");
        System.out.println("  temperatura: " + temperatura + "°c");
        System.out.println("  humidade: " + humidade + "%");
        
        // interpretação simples
        if (temperatura > 30) {
            System.out.println("  sensação: calor");
        } else if (temperatura < 10) {
            System.out.println("  sensação: frio");
        } else {
            System.out.println("  sensação: agradável");
        }
        System.out.println();
    }
}