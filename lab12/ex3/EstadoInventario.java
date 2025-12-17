package Praticas.lab12.ex3;

class EstadoInventario implements EstadoLivro {
    private static final EstadoInventario instancia = new EstadoInventario();
    
    private EstadoInventario() {}
    
    public static EstadoInventario getInstancia() {
        return instancia;
    }
    
    @Override
    public void regista(Livro livro) {
        System.out.println("Livro registado do inventário.");
        livro.setEstado(EstadoDisponivel.getInstancia());
    }
    
    @Override
    public void requisita(Livro livro) {
        System.out.println("Operação não disponível: livro em inventário.");
    }
    
    @Override
    public void devolve(Livro livro) {
        System.out.println("Operação não disponível: livro em inventário.");
    }
    
    @Override
    public void reserva(Livro livro) {
        System.out.println("Operação não disponível: livro em inventário.");
    }
    
    @Override
    public void cancelaReserva(Livro livro) {
        System.out.println("Operação não disponível: livro em inventário.");
    }
    
    @Override
    public String getNomeEstado() {
        return "[Inventário]";
    }
}
