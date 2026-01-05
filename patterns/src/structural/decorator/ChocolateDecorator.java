package structural.decorator;

class ChocolateDecorator extends CafeDecorator {
    public ChocolateDecorator(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescricao() {
        return cafeDecorado.getDescricao() + " + Chocolate";
    }
    
    @Override
    public double getCusto() {
        return cafeDecorado.getCusto() + 1.00;
    }
}
