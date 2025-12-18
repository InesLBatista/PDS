package behavioral.abstract_factory;

public class LinuxFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextBox createTextBox() {
        return new LinuxTextBox();
    }
}
