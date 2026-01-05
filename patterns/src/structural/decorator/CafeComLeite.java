package structural.decorator;

class CafeComLeite implements Cafe {
    @Override
    public String getDescricao() {
        return "Café com Leite";
    }
    
    @Override
    public double getCusto() {
        return 2.50;
    }
}
