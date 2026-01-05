package behavioral.command;

class ControleRemoto {
    private Comando[] botoes;
    private java.util.Stack<Comando> historico;
    private java.util.Stack<Comando> redoHistorico;
    
    public ControleRemoto(int numeroBotoes) {
        botoes = new Comando[numeroBotoes];
        historico = new java.util.Stack<>();
        redoHistorico = new java.util.Stack<>();
    }
    
    public void setComando(int slot, Comando comando) {
        if (slot >= 0 && slot < botoes.length) {
            botoes[slot] = comando;
        }
    }
    
    public void pressionarBotao(int slot) {
        if (slot >= 0 && slot < botoes.length && botoes[slot] != null) {
            botoes[slot].executar();
            historico.push(botoes[slot]);
            redoHistorico.clear(); // Limpa histórico de redo quando nova ação é executada
        }
    }
    
    public void desfazer() {
        if (!historico.isEmpty()) {
            Comando ultimoComando = historico.pop();
            ultimoComando.desfazer();
            redoHistorico.push(ultimoComando);
        } else {
            System.out.println("Nada para desfazer");
        }
    }
    
    public void refazer() {
        if (!redoHistorico.isEmpty()) {
            Comando comandoParaRefazer = redoHistorico.pop();
            comandoParaRefazer.executar();
            historico.push(comandoParaRefazer);
        } else {
            System.out.println("Nada para refazer");
        }
    }
}
