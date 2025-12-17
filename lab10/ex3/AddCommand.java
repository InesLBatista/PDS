package Praticas.lab10.ex3;
import java.util.List;

public class AddCommand<E> implements Command {
    private List<E> list;    // Mudar para List para ter posições
    private E element;
    private int position;    // Guardar a posição onde foi adicionado
    private boolean executed = false;

    public AddCommand(List<E> list, E element) {
        this.list = list;
        this.element = element;
    }

    @Override
    public void execute() {
        list.add(element);   // Adiciona no final
        position = list.size() - 1; // Guarda a posição
        executed = true;
    }

    @Override
    public void undo() {
        if (executed) {
            list.remove(position);  // Remove da posição exata
            executed = false;
        }
    }
}