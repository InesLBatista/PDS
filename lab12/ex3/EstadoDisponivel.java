package Praticas.lab12.ex3;

class EstadoDisponivel implements EstadoLivro {
    private static final EstadoDisponivel instancia = new EstadoDisponivel();
    
    private EstadoDisponivel() {}
    
    public static EstadoDisponivel getInstancia() {
        return instancia;
    }
    
    @Override
    public void regista(Livro livro) {
        System.out.println("Operação não disponível: livro já registado.");
    }
    
    @Override
    public void requisita(Livro livro) {
        System.out.println("Livro requisitado.");
        livro.setEstado(EstadoEmprestado.getInstancia());
    }
    
    @Override
    public void devolve(Livro livro) {
        System.out.println("Operação não disponível: livro já disponível.");
    }
    
    @Override
    public void reserva(Livro livro) {
        System.out.println("Livro reservado.");
        livro.setEstado(EstadoReservado.getInstancia());
    }
    
    @Override
    public void cancelaReserva(Livro livro) {
        System.out.println("Operação não disponível: livro não está reservado.");
    }
    
    @Override
    public String getNomeEstado() {
        return "[Disponível]";
    }
}
