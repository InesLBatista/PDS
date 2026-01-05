package behavioral.command;

class LigarLuzComando implements Comando {
    private Luz luz;
    
    public LigarLuzComando(Luz luz) {
        this.luz = luz;
    }
    
    @Override
    public void executar() {
        luz.ligar();
    }
    
    @Override
    public void desfazer() {
        luz.desligar();
    }
}
