package behavioral.iterator;

class BibliotecaUtil {
    
    public static void percorrerComIterator(Iterator<Livro> iterator, String titulo) {
        System.out.println("\nPercorrendo com " + titulo + ":");
        System.out.println("----------------------------------------");
        while (iterator.hasNext()) {
            Livro livro = iterator.next();
            System.out.println("  • " + livro);
        }
    }
    
    public static void buscarLivroPorTitulo(Iterator<Livro> iterator, String tituloBusca) {
        System.out.println("\nBuscando livro com título contendo: '" + tituloBusca + "'");
        boolean encontrado = false;
        
        while (iterator.hasNext()) {
            Livro livro = iterator.next();
            if (livro.getTitulo().toLowerCase().contains(tituloBusca.toLowerCase())) {
                System.out.println("  ✓ Encontrado: " + livro);
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("  ✗ Nenhum livro encontrado com esse título");
        }
    }
    
    public static double calcularMediaAvaliacao(Iterator<Livro> iterator) {
        double soma = 0;
        int contador = 0;
        
        while (iterator.hasNext()) {
            Livro livro = iterator.next();
            soma += livro.getAvaliacao();
            contador++;
        }
        
        return contador > 0 ? soma / contador : 0;
    }
    
    public static void removerLivrosPorCategoria(Iterator<Livro> iterator, String categoria) {
        System.out.println("\nRemovendo livros da categoria: " + categoria);
        int removidos = 0;
        
        while (iterator.hasNext()) {
            Livro livro = iterator.next();
            if (livro.getCategoria().equalsIgnoreCase(categoria)) {
                iterator.remove();
                removidos++;
                System.out.println("  - Removido: " + livro.getTitulo());
            }
        }
        
        System.out.println("Total removido: " + removidos + " livros");
    }
}
