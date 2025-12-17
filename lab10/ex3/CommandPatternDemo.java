package Praticas.lab10.ex3;
import java.util.*;

// Classe de demonstração do padrão Command
public class CommandPatternDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // Coleção para teste
        CommandInvoker invoker = new CommandInvoker(); // Invocador
        
        // Testa adição com undo
        Command add = new AddCommand<>(list, "Teste");
        invoker.executeCommand(add);
        System.out.println("Após adicionar: " + list);
        
        invoker.undo(); // Desfaz a adição
        System.out.println("Após undo: " + list);
    }
}