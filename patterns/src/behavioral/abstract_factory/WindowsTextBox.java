package behavioral.abstract_factory;

public class WindowsTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Renderizado caixa de texto no SO Windows.");
    }
}
