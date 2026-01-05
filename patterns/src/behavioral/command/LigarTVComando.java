package behavioral.command;

class LigarTVComando implements Comando {
    private Televisao televisao;
    private int canal;
    
    public LigarTVComando(Televisao televisao, int canal) {
        this.televisao = televisao;
        this.canal = canal;
    }
    
    @Override
    public void executar() {
        televisao.setCanal(canal);
        televisao.ligar();
    }
    
    @Override
    public void desfazer() {
        televisao.desligar();
    }
}