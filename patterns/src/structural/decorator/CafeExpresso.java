package structural.decorator;

class CafeExpresso implements Cafe {
    @Override
    public String getDescricao() {
        return "Café Expresso";
    }
    
    @Override
    public double getCusto() {
        return 3.00;
    }
}
