package behavioral.memento;

public class Main {
    public static void main(String[] args) {
        System.out.println("Padrão Memento - Editor de Texto com Histórico\n");
        
        // 1. Criar editor e gerenciador de histórico
        EditorTexto editor = new EditorTexto();
        GerenciadorHistorico historico = new GerenciadorHistorico(20);
        
        System.out.println("Editor criado. Estado inicial:");
        editor.exibirEstado();
        System.out.println();
        
        // 2. Realizar operações e salvar estados
        System.out.println("=== FASE 1: DIGITAÇÃO BÁSICA ===");
        System.out.println("Operação 1: Inserir 'Olá'");
        editor.inserirTexto("Olá");
        historico.salvarEstado(editor);
        editor.exibirEstado();
        
        System.out.println("\nOperação 2: Inserir ' Mundo'");
        editor.inserirTexto(" Mundo");
        historico.salvarEstado(editor);
        editor.exibirEstado();
        
        System.out.println("\nOperação 3: Inserir '!'");
        editor.inserirTexto("!");
        historico.salvarEstado(editor);
        editor.exibirEstado();
        
        // Exibir histórico
        historico.exibirHistorico();
        
        System.out.println("\n=== FASE 2: OPERAÇÕES UNDO ===");
        
        System.out.println("\nUndo 1:");
        if (historico.undo(editor)) {
            System.out.println("Editor após undo:");
            editor.exibirEstado();
        }
        
        System.out.println("\nUndo 2:");
        if (historico.undo(editor)) {
            System.out.println("Editor após undo:");
            editor.exibirEstado();
        }
        
        historico.exibirHistorico();
        
        System.out.println("\n=== FASE 3: OPERAÇÕES REDO ===");
        
        System.out.println("\nRedo 1:");
        if (historico.redo(editor)) {
            System.out.println("Editor após redo:");
            editor.exibirEstado();
        }
        
        System.out.println("\nRedo 2:");
        if (historico.redo(editor)) {
            System.out.println("Editor após redo:");
            editor.exibirEstado();
        }
        
        historico.exibirHistorico();
        
        System.out.println("\n=== FASE 4: FORMATAÇÃO DE TEXTO ===");
        
        System.out.println("\nOperação 4: Alternar negrito");
        editor.alternarNegrito();
        historico.salvarEstado(editor);
        editor.exibirEstado();
        
        System.out.println("\nOperação 5: Alternar itálico");
        editor.alternarItalico();
        historico.salvarEstado(editor);
        editor.exibirEstado();
        
        System.out.println("\nOperação 6: Inserir texto formatado");
        editor.inserirTexto(" Este texto está formatado.");
        historico.salvarEstado(editor);
        editor.exibirEstado();
        
        System.out.println("\n=== FASE 5: UNDO/REDO COM FORMATAÇÃO ===");
        
        System.out.println("\nUndo (remove texto formatado):");
        historico.undo(editor);
        editor.exibirEstado();
        
        System.out.println("\nUndo (remove itálico):");
        historico.undo(editor);
        editor.exibirEstado();
        
        System.out.println("\nUndo (remove negrito):");
        historico.undo(editor);
        editor.exibirEstado();
        
        System.out.println("\nRedo (restaura negrito):");
        historico.redo(editor);
        editor.exibirEstado();
        
        historico.exibirHistorico();
        
        System.out.println("\n=== FASE 6: OPERAÇÕES COMPLEXAS ===");
        
        System.out.println("\nOperação 7: Inserir múltiplas linhas");
        editor.inserirTexto("\nSegunda linha do texto.\nTerceira linha.");
        historico.salvarEstado(editor);
        editor.exibirEstado();
        
        System.out.println("\nOperação 8: Mover cursor e apagar");
        editor.moverCursor(-10); // Move cursor para trás
        editor.apcarTexto(5); // Apaga 5 caracteres
        historico.salvarEstado(editor);
        editor.exibirEstado();
        
        System.out.println("\nOperação 9: Alterar tamanho da fonte");
        editor.setTamanhoFonte(16);
        historico.salvarEstado(editor);
        editor.exibirEstado();
        
        System.out.println("\n=== FASE 7: MÚLTIPLOS NÍVEIS DE UNDO ===");
        
        int undosRealizados = 0;
        System.out.println("\nDesfazendo várias operações:");
        while (historico.undo(editor) && undosRealizados < 5) {
            undosRealizados++;
            System.out.println("\nUndo " + undosRealizados + ":");
            editor.exibirEstado();
        }
        
        historico.exibirHistorico();
        
        System.out.println("\n=== FASE 8: RESTAURAÇÃO PARA PONTO ESPECÍFICO ===");
        
        // Exibir histórico completo para referência
        System.out.println("\nHistórico completo para referência:");
        historico.exibirHistorico();
        
        System.out.println("\nRestaurando para o ponto 3 no histórico:");
        if (historico.restaurarParaPonto(editor, 2)) { // Índice 2 = terceiro estado
            System.out.println("Editor após restauração:");
            editor.exibirEstado();
        }
        
        historico.exibirHistorico();
        
        System.out.println("\n=== FASE 9: LIMPEZA E RECOMEÇO ===");
        
        System.out.println("\nLimpando histórico...");
        historico.limparHistorico();
        
        System.out.println("\nRealizando novas operações sem histórico antigo:");
        editor.inserirTexto("Texto novo após limpeza.");
        historico.salvarEstado(editor);
        editor.exibirEstado();
        
        historico.exibirHistorico();
        
        System.out.println("\n=== FASE 10: DEMONSTRAÇÃO DE ENCAPSULAMENTO ===");
        
        System.out.println("\nTentativa de acessar memento diretamente (não deve funcionar):");
        System.out.println("O código cliente não pode acessar:");
        System.out.println("  - memento.getTexto() - método package-private");
        System.out.println("  - memento.getPosicaoCursor() - método package-private");
        System.out.println("  - Construtor de MementoEditor - package-private");
        System.out.println("\nApenas EditorTexto pode acessar esses métodos.");
        
        // Demonstração: o cliente só pode usar a interface pública
        System.out.println("\nInterface pública disponível para cliente:");
        System.out.println("  - editor.inserirTexto(texto)");
        System.out.println("  - editor.apcarTexto(quantidade)");
        System.out.println("  - historico.salvarEstado(editor)");
        System.out.println("  - historico.undo(editor)");
        System.out.println("  - historico.redo(editor)");
        System.out.println("  - editor.exibirEstado() (apenas visualização)");
        
        System.out.println("\n=== FASE 11: TESTE DE LIMITE DE HISTÓRICO ===");
        
        // Testar limite do histórico
        GerenciadorHistorico historicoLimitado = new GerenciadorHistorico(3);
        EditorTexto editorTeste = new EditorTexto();
        
        System.out.println("\nSalvando 5 estados em histórico com limite 3:");
        for (int i = 1; i <= 5; i++) {
            editorTeste.inserirTexto("Texto " + i + " ");
            historicoLimitado.salvarEstado(editorTeste);
            System.out.println("  Estado " + i + " salvo. Histórico: " + 
                             historicoLimitado.getTamanhoHistoricoUndo() + " estados");
        }
        
        historicoLimitado.exibirHistorico();
        
        System.out.println("\n==============================================\n");

    }
}
