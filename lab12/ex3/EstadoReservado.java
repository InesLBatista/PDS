package Praticas.lab12.ex3;

class EstadoReservado implements EstadoLivro {
    private static final EstadoReservado instancia = new EstadoReservado();
    
    private EstadoReservado() {}
    
    public static EstadoReservado getInstancia() {
        return instancia;
    }
    
    @Override
    public void regista(Livro livro) {
        System.out.println("Operação não disponível: livro já registado.");
    }
    
    @Override
    public void requisita(Livro livro) {
        System.out.println("Livro requisitado (estava reservado).");
        livro.setEstado(EstadoEmprestado.getInstancia());
    }
    
    @Override
    public void devolve(Livro livro) {
        System.out.println("Operação não disponível: livro não está emprestado.");
    }
    
    @Override
    public void reserva(Livro livro) {
        System.out.println("Operação não disponível: livro já está reservado.");
    }
    
    @Override
    public void cancelaReserva(Livro livro) {
        System.out.println("Reserva cancelada.");
        livro.setEstado(EstadoDisponivel.getInstancia());
    }
    
    @Override
    public String getNomeEstado() {
        return "[Reservado]";
    }
}
