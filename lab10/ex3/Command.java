package Praticas.lab10.ex3;

// Interface para comandos com operações execute e undo
public interface Command {
    void execute();
    void undo();
}