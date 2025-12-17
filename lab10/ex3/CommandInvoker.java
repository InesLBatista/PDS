package Praticas.lab10.ex3;
import java.util.*;

// Invocador que gere o histórico de comandos para undo
public class CommandInvoker {
    private Stack<Command> history = new Stack<>(); // Pilha de comandos

    public void executeCommand(Command command) {
        command.execute();     // Executa o comando
        history.push(command); // Guarda no histórico
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.pop(); // Pega último comando
            command.undo();                  // Executa undo
        }
    }
}
