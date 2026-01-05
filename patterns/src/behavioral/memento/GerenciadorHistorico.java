package behavioral.memento;
import java.util.*;
class GerenciadorHistorico {
    private Stack<MementoEditor> pilhaUndo;
    private Stack<MementoEditor> pilhaRedo;
    private final int limiteHistorico;
    
    public GerenciadorHistorico() {
        this(50); // Limite padrão de 50 estados
    }
    
    public GerenciadorHistorico(int limiteHistorico) {
        this.pilhaUndo = new Stack<>();
        this.pilhaRedo = new Stack<>();
        this.limiteHistorico = Math.max(10, limiteHistorico);
    }
    
    public void salvarEstado(EditorTexto editor) {
        // Limpa a pilha redo quando novo estado é salvo
        pilhaRedo.clear();
        
        // Cria e salva novo memento
        MementoEditor memento = editor.criarMemento();
        pilhaUndo.push(memento);
        
        // Mantém limite do histórico
        if (pilhaUndo.size() > limiteHistorico) {
            // Remove os estados mais antigos (do fundo da pilha)
            List<MementoEditor> temp = new ArrayList<>(pilhaUndo);
            temp.remove(0); // Remove o mais antigo
            pilhaUndo.clear();
            pilhaUndo.addAll(temp);
        }
    }
    
    public boolean undo(EditorTexto editor) {
        if (!pilhaUndo.isEmpty()) {
            // Remove estado atual da pilha undo
            MementoEditor estadoAtual = pilhaUndo.pop();
            
            // Salva estado atual na pilha redo (se não for vazio)
            if (!pilhaUndo.isEmpty()) {
                MementoEditor estadoAnterior = pilhaUndo.peek();
                pilhaRedo.push(estadoAtual);
                editor.restaurarMemento(estadoAnterior);
                return true;
            } else {
                // Último estado - mantém editor vazio
                pilhaRedo.push(estadoAtual);
                editor.restaurarMemento(new MementoEditor("", 0, new FormatoTexto()));
                return true;
            }
        }
        return false;
    }
    
    public boolean redo(EditorTexto editor) {
        if (!pilhaRedo.isEmpty()) {
            MementoEditor estadoRedo = pilhaRedo.pop();
            pilhaUndo.push(estadoRedo);
            editor.restaurarMemento(estadoRedo);
            return true;
        }
        return false;
    }
    
    public void limparHistorico() {
        pilhaUndo.clear();
        pilhaRedo.clear();
    }
    
    public int getTamanhoHistoricoUndo() {
        return pilhaUndo.size();
    }
    
    public int getTamanhoHistoricoRedo() {
        return pilhaRedo.size();
    }
    
    public void exibirHistorico() {
        System.out.println("\n=== HISTÓRICO ===");
        System.out.println("Undo disponível: " + pilhaUndo.size() + " estados");
        System.out.println("Redo disponível: " + pilhaRedo.size() + " estados");
        
        if (!pilhaUndo.isEmpty()) {
            System.out.println("\nÚltimos estados (mais recente primeiro):");
            int limiteExibicao = Math.min(5, pilhaUndo.size());
            for (int i = 0; i < limiteExibicao; i++) {
                MementoEditor memento = pilhaUndo.get(pilhaUndo.size() - 1 - i);
                System.out.println("  " + (i + 1) + ". " + memento);
            }
            if (pilhaUndo.size() > 5) {
                System.out.println("  ... mais " + (pilhaUndo.size() - 5) + " estados");
            }
        }
    }
    
    // Método para restaurar para um ponto específico (avançado)
    public boolean restaurarParaPonto(EditorTexto editor, int indice) {
        if (indice >= 0 && indice < pilhaUndo.size()) {
            // Calcula quantos undos são necessários
            int undosNecessarios = pilhaUndo.size() - 1 - indice;
            
            // Move estados para pilha redo
            for (int i = 0; i < undosNecessarios; i++) {
                if (!pilhaUndo.isEmpty()) {
                    pilhaRedo.push(pilhaUndo.pop());
                }
            }
            
            // Restaura estado
            if (!pilhaUndo.isEmpty()) {
                editor.restaurarMemento(pilhaUndo.peek());
                return true;
            }
        }
        return false;
    }
}
