package behavioral.abstract_factory;

public class LinuxTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Renderizado caixa de texto no SO Linux.");
    }
}
