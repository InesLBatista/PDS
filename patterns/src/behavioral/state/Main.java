package behavioral.state;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("padrão state - reprodutor de música\n");
        
        // criar lista de faixas
        List<String> faixas = new ArrayList<>();
        faixas.add("música 1 - artista a");
        faixas.add("música 2 - artista b");
        faixas.add("música 3 - artista c");
        faixas.add("música 4 - artista d");
        
        // criar reprodutor
        ReprodutorMusica reprodutor = new ReprodutorMusica(faixas);
        
        System.out.println("reprodutor criado com " + faixas.size() + " faixas");
        System.out.println("estado inicial:");
        reprodutor.mostrarEstado();
        
        System.out.println("========================================\n");
        
        // testar operações no estado parado
        System.out.println("teste 1: operações no estado parado");
        System.out.println("------------------------------------\n");
        
        System.out.println("tentativa: pausar (deve falhar)");
        reprodutor.pausar();
        
        System.out.println("\ntentativa: parar (já está parado)");
        reprodutor.parar();
        
        System.out.println("\ntentativa: próxima faixa");
        reprodutor.proximaFaixa();
        
        System.out.println("\ntentativa: reproduzir (deve funcionar)");
        reprodutor.reproduzir();
        
        System.out.println("\n========================================\n");
        
        // testar operações no estado a reproduzir
        System.out.println("teste 2: operações a reproduzir");
        System.out.println("--------------------------------\n");
        
        System.out.println("tentativa: reproduzir (já está a reproduzir)");
        reprodutor.reproduzir();
        
        System.out.println("\ntentativa: próxima faixa");
        reprodutor.proximaFaixa();
        
        System.out.println("\ntentativa: faixa anterior");
        reprodutor.faixaAnterior();
        
        System.out.println("\ntentativa: pausar (deve funcionar)");
        reprodutor.pausar();
        
        System.out.println("\n========================================\n");
        
        // testar operações no estado pausado
        System.out.println("teste 3: operações pausado");
        System.out.println("---------------------------\n");
        
        System.out.println("tentativa: pausar (já está pausado)");
        reprodutor.pausar();
        
        System.out.println("\ntentativa: próxima faixa (deve falhar)");
        reprodutor.proximaFaixa();
        
        System.out.println("\ntentativa: continuar reprodução");
        reprodutor.reproduzir();
        
        System.out.println("\ntentativa: parar");
        reprodutor.parar();
        
        System.out.println("\n========================================\n");
        
        // fluxo completo de uso
        System.out.println("teste 4: fluxo completo de uso");
        System.out.println("-------------------------------\n");
        
        System.out.println("1. iniciar reprodução");
        reprodutor.reproduzir();
        
        System.out.println("\n2. pausar");
        reprodutor.pausar();
        
        System.out.println("\n3. continuar");
        reprodutor.reproduzir();
        
        System.out.println("\n4. mudar para próxima faixa");
        reprodutor.proximaFaixa();
        
        System.out.println("\n5. parar completamente");
        reprodutor.parar();
        
        System.out.println("\n========================================\n");
        
        // demonstrar adição de novo estado
        System.out.println("demonstração: adicionar novo estado (modo aleatório)");
        System.out.println("-----------------------------------------------------\n");
        
        System.out.println("para adicionar novo estado:");
        System.out.println("1. criar nova classe EstadoAleatorio implementando EstadoReproducao");
        System.out.println("2. implementar comportamento específico do modo aleatório");
        System.out.println("3. adicionar referência no ReprodutorMusica");
        System.out.println("4. estados existentes não precisam ser modificados");
        
        // exemplo de como seria a nova classe
        System.out.println("\nexemplo da nova classe:");
        System.out.println("""
            class EstadoAleatorio implements EstadoReproducao {
                // implementação específica do modo aleatório
                // pode mudar para faixa aleatória em vez de sequencial
                // outras operações têm comportamento diferente
            }
            """);
        
        System.out.println("========================================\n");
        
        // mostrar estados finais
        System.out.println("estado final do sistema:");
        System.out.println("-----------------------");
        reprodutor.mostrarEstado();

    }
}