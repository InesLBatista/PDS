package behavioral.command;

class DiminuirTemperaturaComando implements Comando {
    private ArCondicionado arCondicionado;
    private int quantidade;
    
    public DiminuirTemperaturaComando(ArCondicionado arCondicionado, int quantidade) {
        this.arCondicionado = arCondicionado;
        this.quantidade = quantidade;
    }
    
    @Override
    public void executar() {
        int novaTemperatura = arCondicionado.getTemperatura() - quantidade;
        arCondicionado.setTemperatura(novaTemperatura);
    }
    
    @Override
    public void desfazer() {
        arCondicionado.voltarTemperaturaAnterior();
    }
}
