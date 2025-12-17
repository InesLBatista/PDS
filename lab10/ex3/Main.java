package Praticas.lab10.ex3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        CommandInvoker invoker = new CommandInvoker();
        
        System.out.println("TESTE DO PADRÃO COMMAND");
        System.out.println("Lista inicial: " + lista);
        
        // Teste: Adicionar elementos
        System.out.println("\n--- A adicionar elementos ---");
        invoker.executeCommand(new AddCommand<>(lista, "Maçã"));
        System.out.println("Após adicionar Maçã: " + lista);
        
        invoker.executeCommand(new AddCommand<>(lista, "Banana"));
        System.out.println("Após adicionar Banana: " + lista);
        
        invoker.executeCommand(new AddCommand<>(lista, "Laranja"));
        System.out.println("Após adicionar Laranja: " + lista);
        
        // Teste: Remover elemento do meio
        System.out.println("\n--- A remover elemento do meio ---");
        invoker.executeCommand(new RemoveCommand<>(lista, "Banana"));
        System.out.println("Após remover Banana: " + lista);
        
        // Teste: Fazer undo
        System.out.println("\n--- A fazer UNDO ---");
        invoker.undo(); // Banana deve voltar à posição original
        System.out.println("Undo 1 - Banana volta: " + lista);
        
        // Teste: Remover primeiro elemento
        System.out.println("\n--- A remover primeiro elemento ---");
        invoker.executeCommand(new RemoveCommand<>(lista, "Maçã"));
        System.out.println("Após remover Maçã: " + lista);
        
        invoker.undo(); // Maçã deve voltar ao início
        System.out.println("Undo 2 - Maçã volta: " + lista);
    }
}