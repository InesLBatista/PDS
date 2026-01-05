package behavioral.state;

class EstadoReproduzindo implements EstadoReproducao {
    private ReprodutorMusica reprodutor;
    
    public EstadoReproduzindo(ReprodutorMusica reprodutor) {
        this.reprodutor = reprodutor;
    }
    
    @Override
    public void reproduzir() {
        System.out.println("já está a reproduzir");
    }
    
    @Override
    public void pausar() {
        System.out.println("a pausar reprodução...");
        reprodutor.setEstado(reprodutor.getEstadoPausado());
    }
    
    @Override
    public void parar() {
        System.out.println("a parar reprodução...");
        reprodutor.setEstado(reprodutor.getEstadoParado());
    }
    
    @Override
    public void proximaFaixa() {
        reprodutor.selecionarProximaFaixa();
        System.out.println("a avançar para próxima faixa...");
        reprodutor.reproduzirFaixaAtual();
    }
    
    @Override
    public void faixaAnterior() {
        reprodutor.selecionarFaixaAnterior();
        System.out.println("a retroceder para faixa anterior...");
        reprodutor.reproduzirFaixaAtual();
    }
    
    @Override
    public String getNomeEstado() {
        return "a reproduzir";
    }
}
