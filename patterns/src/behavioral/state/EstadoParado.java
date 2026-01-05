package behavioral.state;

class EstadoParado implements EstadoReproducao {
    private ReprodutorMusica reprodutor;
    
    public EstadoParado(ReprodutorMusica reprodutor) {
        this.reprodutor = reprodutor;
    }
    
    @Override
    public void reproduzir() {
        System.out.println("a iniciar reprodução...");
        reprodutor.setEstado(reprodutor.getEstadoReproduzindo());
        reprodutor.reproduzirFaixaAtual();
    }
    
    @Override
    public void pausar() {
        System.out.println("não é possível pausar - a reprodução está parada");
    }
    
    @Override
    public void parar() {
        System.out.println("já está parado");
    }
    
    @Override
    public void proximaFaixa() {
        reprodutor.selecionarProximaFaixa();
        System.out.println("próxima faixa seleccionada: " + reprodutor.getFaixaAtual());
    }
    
    @Override
    public void faixaAnterior() {
        reprodutor.selecionarFaixaAnterior();
        System.out.println("faixa anterior seleccionada: " + reprodutor.getFaixaAtual());
    }
    
    @Override
    public String getNomeEstado() {
        return "parado";
    }
}