package behavioral.command;

class DesligarTVComando implements Comando {
    private Televisao televisao;
    
    public DesligarTVComando(Televisao televisao) {
        this.televisao = televisao;
    }
    
    @Override
    public void executar() {
        televisao.desligar();
    }
    
    @Override
    public void desfazer() {
        televisao.ligar();
    }
}
