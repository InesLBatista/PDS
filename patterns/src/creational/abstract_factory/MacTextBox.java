package creational.abstract_factory;

public class MacTextBox implements TextBox  {
    @Override
    public void render() {
        System.out.println("Renderizado caixa de texto no SO Mac.");
    }
}
