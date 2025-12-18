package creational.abstract_factory;

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizado botão no SO Mac.");
    }
}
