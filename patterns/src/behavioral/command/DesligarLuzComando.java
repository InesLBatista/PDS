package behavioral.command;

class DesligarLuzComando implements Comando {
    private Luz luz;
    
    public DesligarLuzComando(Luz luz) {
        this.luz = luz;
    }
    
    @Override
    public void executar() {
        luz.desligar();
    }
    
    @Override
    public void desfazer() {
        luz.ligar();
    }
}
