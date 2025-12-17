package Praticas.lab12.ex3;

class EstadoEmprestado implements EstadoLivro {
    private static final EstadoEmprestado instancia = new EstadoEmprestado();
    
    private EstadoEmprestado() {}
    
    public static EstadoEmprestado getInstancia() {
        return instancia;
    }
    
    @Override
    public void regista(Livro livro) {
        System.out.println("Operação não disponível: livro já registado.");
    }
    
    @Override
    public void requisita(Livro livro) {
        System.out.println("Operação não disponível: livro já emprestado.");
    }
    
    @Override
    public void devolve(Livro livro) {
        System.out.println("Livro devolvido.");
        livro.setEstado(EstadoDisponivel.getInstancia());
    }
    
    @Override
    public void reserva(Livro livro) {
        System.out.println("Livro reservado para quando for devolvido.");
        livro.setEstado(EstadoReservado.getInstancia());
    }
    
    @Override
    public void cancelaReserva(Livro livro) {
        System.out.println("Operação não disponível: livro não está reservado.");
    }
    
    @Override
    public String getNomeEstado() {
        return "[Emprestado]";
    }
}
