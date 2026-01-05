package behavioral.command;

class AumentarTemperaturaComando implements Comando {
    private ArCondicionado arCondicionado;
    private int quantidade;
    
    public AumentarTemperaturaComando(ArCondicionado arCondicionado, int quantidade) {
        this.arCondicionado = arCondicionado;
        this.quantidade = quantidade;
    }
    
    @Override
    public void executar() {
        int novaTemperatura = arCondicionado.getTemperatura() + quantidade;
        arCondicionado.setTemperatura(novaTemperatura);
    }
    
    @Override
    public void desfazer() {
        arCondicionado.voltarTemperaturaAnterior();
    }
}
