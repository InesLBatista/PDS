package behavioral.state;
class EstadoPausado implements EstadoReproducao {
    private ReprodutorMusica reprodutor;
    
    public EstadoPausado(ReprodutorMusica reprodutor) {
        this.reprodutor = reprodutor;
    }
    
    @Override
    public void reproduzir() {
        System.out.println("a continuar reprodução...");
        reprodutor.setEstado(reprodutor.getEstadoReproduzindo());
    }
    
    @Override
    public void pausar() {
        System.out.println("já está pausado");
    }
    
    @Override
    public void parar() {
        System.out.println("a parar reprodução...");
        reprodutor.setEstado(reprodutor.getEstadoParado());
    }
    
    @Override
    public void proximaFaixa() {
        System.out.println("não é possível mudar de faixa enquanto pausado");
    }
    
    @Override
    public void faixaAnterior() {
        System.out.println("não é possível mudar de faixa enquanto pausado");
    }
    
    @Override
    public String getNomeEstado() {
        return "pausado";
    }
}
