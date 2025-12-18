package behavioral.abstract_factory;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizado botão no SO Windows.");
    }
}
