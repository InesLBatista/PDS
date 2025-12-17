package Praticas.lab12.ex3;

import java.util.*;

public class Main {
    private static List<Livro> livros = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        livros.add(new Livro("Os Lusíadas", "978-972-37-0478-3", 1572, "Luís de Camões"));
        livros.add(new Livro("Mensagem", "978-972-0-04127-6", 1934, "Fernando Pessoa"));
        livros.add(new Livro("Memorial do Convento", "978-972-21-0448-4", 1982, "José Saramago"));
        livros.add(new Livro("Os Maias", "978-972-23-1467-2", 1888, "Eça de Queirós"));
        livros.add(new Livro("Livro do Desassossego", "978-972-37-0769-2", 1982, "Bernardo Soares"));
        
        boolean continuar = true;
        
        System.out.println("Biblioteca: ");

        
        while (continuar) {
            exibirBiblioteca();
            
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("sair")) {
                continuar = false;
                continue;
            }
            
            try {
                String[] partes = input.split(",");
                if (partes.length != 2) {
                    System.out.println("Formato inválido! Use: numeroLivro,numeroOperacao");
                    continue;
                }
                
                int indexLivro = Integer.parseInt(partes[0].trim()) - 1;
                int operacao = Integer.parseInt(partes[1].trim());
                
                if (indexLivro < 0 || indexLivro >= livros.size()) {
                    System.out.println("Número de livro inválido!");
                    continue;
                }
                
                Livro livro = livros.get(indexLivro);
                executarOperacao(livro, operacao);
                
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Use números.");
            }
        }
        
        System.out.println("Programa terminado.");
        scanner.close();
    }
    
    private static void exibirBiblioteca() {
        System.out.println("\nBiblioteca: ");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println((i + 1) + "  " + livros.get(i));
        }
    }
    
    private static void executarOperacao(Livro livro, int operacao) {
        switch (operacao) {
            case 1:
                livro.regista();
                break;
            case 2:
                livro.requisita();
                break;
            case 3:
                livro.devolve();
                break;
            case 4:
                livro.reserva();
                break;
            case 5:
                livro.cancelaReserva();
                break;
            default:
                System.out.println("Operação inválida! Use 1-5.");
        }
    }
}