package creational.abstract_factory;

public class LinuxButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizado botão no SO Linux.");
    }
}
