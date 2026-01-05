package behavioral.iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Padrão Iterator - Sistema de Biblioteca Digital\n");
        
        // 1. Criar biblioteca e adicionar livros
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis", "Romance", 1899, 4.8));
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell", "Ficção Científica", 1949, 4.7));
        biblioteca.adicionarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", 1954, 4.9));
        biblioteca.adicionarLivro(new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Fantasia", 1997, 4.6));
        biblioteca.adicionarLivro(new Livro("Cem Anos de Solidão", "Gabriel García Márquez", "Realismo Mágico", 1967, 4.8));
        biblioteca.adicionarLivro(new Livro("A Revolução dos Bichos", "George Orwell", "Sátira", 1945, 4.5));
        biblioteca.adicionarLivro(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantil", 1943, 4.9));
        biblioteca.adicionarLivro(new Livro("O Hobbit", "J.R.R. Tolkien", "Fantasia", 1937, 4.7));
        
        System.out.println("Biblioteca criada com " + biblioteca.getTamanho() + " livros\n");
        
        // 2. Testar diferentes tipos de iteração
        
        System.out.println("1. ITERAÇÃO SIMPLES (ordem de inserção):");
        System.out.println("==========================================");
        Iterator<Livro> iteratorSimples = biblioteca.criarIterator();
        BibliotecaUtil.percorrerComIterator(iteratorSimples, "Iterator Simples");
        
        System.out.println("\n\n2. ITERAÇÃO ALFABÉTICA (por título):");
        System.out.println("==========================================");
        Iterator<Livro> iteratorAlfabetico = biblioteca.criarIteratorAlfabetico();
        BibliotecaUtil.percorrerComIterator(iteratorAlfabetico, "Iterator Alfabético");
        
        System.out.println("\n\n3. ITERAÇÃO POR ANO (mais recente primeiro):");
        System.out.println("================================================");
        Iterator<Livro> iteratorPorAno = biblioteca.criarIteratorPorAno();
        BibliotecaUtil.percorrerComIterator(iteratorPorAno, "Iterator por Ano");
        
        System.out.println("\n\n4. ITERAÇÃO POR CATEGORIA (apenas Fantasia):");
        System.out.println("================================================");
        Iterator<Livro> iteratorFantasia = biblioteca.criarIteratorPorCategoria("Fantasia");
        BibliotecaUtil.percorrerComIterator(iteratorFantasia, "Iterator por Categoria (Fantasia)");
        
        System.out.println("\n\n5. ITERAÇÃO POR AVALIAÇÃO (melhores primeiro):");
        System.out.println("==================================================");
        Iterator<Livro> iteratorAvaliacao = biblioteca.criarIteratorPorAvaliacao();
        BibliotecaUtil.percorrerComIterator(iteratorAvaliacao, "Iterator por Avaliação");
        
        System.out.println("\n\n6. OPERAÇÕES COM ITERADORES:");
        System.out.println("=============================");
        
        // Buscar livro por título
        Iterator<Livro> iteratorBusca = biblioteca.criarIterator();
        BibliotecaUtil.buscarLivroPorTitulo(iteratorBusca, "anéis");
        
        // Calcular média de avaliação
        Iterator<Livro> iteratorMedia = biblioteca.criarIterator();
        double media = BibliotecaUtil.calcularMediaAvaliacao(iteratorMedia);
        System.out.printf("\nMédia de avaliação da biblioteca: %.2f★\n", media);
        
        System.out.println("\n\n7. OPERAÇÃO DE REMOÇÃO DURANTE ITERAÇÃO:");
        System.out.println("==========================================");
        
        // Criar cópia para demonstração de remoção
        Biblioteca bibliotecaCopia = new Biblioteca();
        for (Livro livro : biblioteca.getLivros()) {
            bibliotecaCopia.adicionarLivro(livro);
        }
        
        System.out.println("Biblioteca antes da remoção: " + bibliotecaCopia.getTamanho() + " livros");
        
        // Remover livros da categoria Fantasia
        Iterator<Livro> iteratorRemocao = bibliotecaCopia.criarIteratorPorCategoria("Fantasia");
        BibliotecaUtil.removerLivrosPorCategoria(iteratorRemocao, "Fantasia");
        
        System.out.println("Biblioteca após remoção: " + bibliotecaCopia.getTamanho() + " livros");
        
        System.out.println("\n\n8. MÚLTIPLOS ITERADORES SIMULTÂNEOS:");
        System.out.println("======================================");
        
        // Demonstrar múltiplos iteradores na mesma coleção
        System.out.println("Criando 3 iteradores diferentes na mesma biblioteca:");
        
        Iterator<Livro> iterador1 = biblioteca.criarIterator();
        Iterator<Livro> iterador2 = biblioteca.criarIteratorAlfabetico();
        Iterator<Livro> iterador3 = biblioteca.criarIteratorPorAno();
        
        System.out.println("\nIterador 1 (simples) - Primeiros 3 livros:");
        for (int i = 0; i < 3 && iterador1.hasNext(); i++) {
            System.out.println("  • " + iterador1.next().getTitulo());
        }
        
        System.out.println("\nIterador 2 (alfabético) - Primeiros 3 livros:");
        for (int i = 0; i < 3 && iterador2.hasNext(); i++) {
            System.out.println("  • " + iterador2.next().getTitulo());
        }
        
        System.out.println("\nIterador 3 (por ano) - Primeiros 3 livros:");
        for (int i = 0; i < 3 && iterador3.hasNext(); i++) {
            System.out.println("  • " + iterador3.next().getTitulo());
        }
        
        System.out.println("\n\n9. ITERAÇÃO PERSONALIZADA:");
        System.out.println("===========================");
        
        // Demonstrar iteração com critério personalizado
        System.out.println("Livros publicados após 1950:");
        Iterator<Livro> iteratorPersonalizado = biblioteca.criarIterator();
        
        while (iteratorPersonalizado.hasNext()) {
            Livro livro = iteratorPersonalizado.next();
            if (livro.getAnoPublicacao() > 1950) {
                System.out.println("  • " + livro.getTitulo() + " (" + livro.getAnoPublicacao() + ")");
            }
        }
    }
}
