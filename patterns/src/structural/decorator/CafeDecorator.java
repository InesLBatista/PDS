package structural.decorator;

abstract class CafeDecorator implements Cafe {
    protected Cafe cafeDecorado;
    
    public CafeDecorator(Cafe cafe) {
        this.cafeDecorado = cafe;
    }
    
    @Override
    public String getDescricao() {
        return cafeDecorado.getDescricao();
    }
    
    @Override
    public double getCusto() {
        return cafeDecorado.getCusto();
    }
}
