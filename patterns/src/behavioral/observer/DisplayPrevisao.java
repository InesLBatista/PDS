package behavioral.observer;

class DisplayPrevisao implements Observador {
    private float ultimaPressao;
    private String previsao;
    private String nome;
    
    public DisplayPrevisao(String nome) {
        this.nome = nome;
        this.ultimaPressao = 1013.25f; // pressão padrão ao nível do mar
        this.previsao = "indeterminada";
        System.out.println("display de previsão criado: " + nome);
    }
    
    @Override
    public void atualizar(float temperatura, float humidade, float pressao) {
        String novaPrevisao = calcularPrevisao(pressao);
        
        if (!novaPrevisao.equals(previsao)) {
            previsao = novaPrevisao;
            ultimaPressao = pressao;
            exibir();
        }
    }
    
    private String calcularPrevisao(float pressaoActual) {
        float diferenca = pressaoActual - ultimaPressao;
        
        if (diferenca > 3.5) {
            return "melhora no tempo";
        } else if (diferenca > 1.5) {
            return "poucas mudanças, possibilidade de sol";
        } else if (diferenca > -1.5) {
            return "tempo estável";
        } else if (diferenca > -3.5) {
            return "possibilidade de chuva";
        } else {
            return "tempo a piorar, chuva provável";
        }
    }
    
    private void exibir() {
        System.out.println("[" + nome + "] previsão do tempo:");
        System.out.println("  condição: " + previsao);
        System.out.println("  baseada na variação de pressão");
        System.out.println();
    }
}
