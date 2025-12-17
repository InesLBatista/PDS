package Praticas.lab10.ex3;
import java.util.List;

public class RemoveCommand<E> implements Command {
    private List<E> list;
    private E element;
    private int position;           // Guardar a posição original
    private boolean executed = false;

    public RemoveCommand(List<E> list, E element) {
        this.list = list;
        this.element = element;
    }

    @Override
    public void execute() {
        position = list.indexOf(element); // Encontra a posição
        if (position != -1) {
            list.remove(position);        // Remove da posição exata
            executed = true;
        }
    }

    @Override
    public void undo() {
        if (executed) {
            list.add(position, element);  // Recoloca na posição original
            executed = false;
        }
    }
}
