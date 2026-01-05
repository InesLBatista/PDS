package structural.decorator;

class CanelaDecorator extends CafeDecorator {
    public CanelaDecorator(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescricao() {
        return cafeDecorado.getDescricao() + " + Canela";
    }
    
    @Override
    public double getCusto() {
        return cafeDecorado.getCusto() + 0.25;
    }
}
