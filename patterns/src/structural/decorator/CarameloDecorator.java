package structural.decorator;

class CarameloDecorator extends CafeDecorator {
    public CarameloDecorator(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescricao() {
        return cafeDecorado.getDescricao() + " + Caramelo";
    }
    
    @Override
    public double getCusto() {
        return cafeDecorado.getCusto() + 0.80;
    }
}
