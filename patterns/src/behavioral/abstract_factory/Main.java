package behavioral.abstract_factory;

public class Main {
    public static void main(String[] args) {
        GUIFactory factory;

        // sistema operativo que vou testar
        String platform = "MAC";

        switch (platform) {
            case "WINDOWS":
                factory = new WindowsFactory();
                break;
            case "MAC":
                factory = new MacFactory();
                break;
            case "LINUX":
                factory = new LinuxFactory();
                break;
            default:
                throw new IllegalArgumentException("Plataforma não suportada");
        }

        Button button = factory.createButton();
        TextBox textBox = factory.createTextBox();

        button.render();
        textBox.render();
    }
}