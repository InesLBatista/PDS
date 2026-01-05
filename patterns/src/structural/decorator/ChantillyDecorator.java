package structural.decorator;

class ChantillyDecorator extends CafeDecorator {
    public ChantillyDecorator(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescricao() {
        return cafeDecorado.getDescricao() + " + Chantilly";
    }
    
    @Override
    public double getCusto() {
        return cafeDecorado.getCusto() + 0.75;
    }
}

