package structural.decorator;

class LeiteDecorator extends CafeDecorator {
    public LeiteDecorator(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescricao() {
        return cafeDecorado.getDescricao() + " + Leite";
    }
    
    @Override
    public double getCusto() {
        return cafeDecorado.getCusto() + 0.50;
    }
}