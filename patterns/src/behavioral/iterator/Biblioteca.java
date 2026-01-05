package behavioral.iterator;

import java.util.*;

class Biblioteca implements ColecaoLivros<Livro> {
    private List<Livro> livros;
    
    public Biblioteca() {
        this.livros = new ArrayList<>();
    }
    
    @Override
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
    
    @Override
    public int getTamanho() {
        return livros.size();
    }
    
    public List<Livro> getLivros() {
        return new ArrayList<>(livros);
    }
    
    // 5. Diferentes tipos de iteradores
    
    @Override
    public Iterator<Livro> criarIterator() {
        return new IteratorSimples();
    }
    
    // Iterator simples (ordem de inserção)
    class IteratorSimples implements Iterator<Livro> {
        private int posicao = 0;
        
        @Override
        public boolean hasNext() {
            return posicao < livros.size();
        }
        
        @Override
        public Livro next() {
            if (hasNext()) {
                return livros.get(posicao++);
            }
            return null;
        }
        
        @Override
        public void remove() {
            if (posicao > 0) {
                livros.remove(--posicao);
            }
        }
    }
    
    // Iterator por ordem alfabética
    public Iterator<Livro> criarIteratorAlfabetico() {
        return new IteratorAlfabetico();
    }
    
    class IteratorAlfabetico implements Iterator<Livro> {
        private List<Livro> livrosOrdenados;
        private int posicao = 0;
        
        public IteratorAlfabetico() {
            livrosOrdenados = new ArrayList<>(livros);
            Collections.sort(livrosOrdenados, new Comparator<Livro>() {
                @Override
                public int compare(Livro l1, Livro l2) {
                    return l1.getTitulo().compareTo(l2.getTitulo());
                }
            });
        }
        
        @Override
        public boolean hasNext() {
            return posicao < livrosOrdenados.size();
        }
        
        @Override
        public Livro next() {
            if (hasNext()) {
                return livrosOrdenados.get(posicao++);
            }
            return null;
        }
        
        @Override
        public void remove() {
            // Remove do original baseado no título
            if (posicao > 0) {
                Livro livroAtual = livrosOrdenados.get(posicao - 1);
                livros.removeIf(l -> l.getTitulo().equals(livroAtual.getTitulo()));
            }
        }
    }
    
    // Iterator por ano de publicação (mais recente primeiro)
    public Iterator<Livro> criarIteratorPorAno() {
        return new IteratorPorAno();
    }
    
    class IteratorPorAno implements Iterator<Livro> {
        private List<Livro> livrosOrdenados;
        private int posicao = 0;
        
        public IteratorPorAno() {
            livrosOrdenados = new ArrayList<>(livros);
            Collections.sort(livrosOrdenados, new Comparator<Livro>() {
                @Override
                public int compare(Livro l1, Livro l2) {
                    return Integer.compare(l2.getAnoPublicacao(), l1.getAnoPublicacao());
                }
            });
        }
        
        @Override
        public boolean hasNext() {
            return posicao < livrosOrdenados.size();
        }
        
        @Override
        public Livro next() {
            if (hasNext()) {
                return livrosOrdenados.get(posicao++);
            }
            return null;
        }
        
        @Override
        public void remove() {
            if (posicao > 0) {
                Livro livroAtual = livrosOrdenados.get(posicao - 1);
                livros.removeIf(l -> l.getTitulo().equals(livroAtual.getTitulo()));
            }
        }
    }
    
    // Iterator por categoria específica
    public Iterator<Livro> criarIteratorPorCategoria(String categoria) {
        return new IteratorPorCategoria(categoria);
    }
    
    class IteratorPorCategoria implements Iterator<Livro> {
        private List<Livro> livrosFiltrados;
        private int posicao = 0;
        private String categoria;
        
        public IteratorPorCategoria(String categoria) {
            this.categoria = categoria;
            livrosFiltrados = new ArrayList<>();
            for (Livro livro : livros) {
                if (livro.getCategoria().equalsIgnoreCase(categoria)) {
                    livrosFiltrados.add(livro);
                }
            }
        }
        
        @Override
        public boolean hasNext() {
            return posicao < livrosFiltrados.size();
        }
        
        @Override
        public Livro next() {
            if (hasNext()) {
                return livrosFiltrados.get(posicao++);
            }
            return null;
        }
        
        @Override
        public void remove() {
            if (posicao > 0) {
                Livro livroAtual = livrosFiltrados.get(posicao - 1);
                livros.removeIf(l -> l.getTitulo().equals(livroAtual.getTitulo()));
                // Atualiza lista filtrada
                livrosFiltrados.remove(posicao - 1);
                posicao--;
            }
        }
    }
    
    // Iterator por avaliação (melhores primeiro)
    public Iterator<Livro> criarIteratorPorAvaliacao() {
        return new IteratorPorAvaliacao();
    }
    
    class IteratorPorAvaliacao implements Iterator<Livro> {
        private List<Livro> livrosOrdenados;
        private int posicao = 0;
        
        public IteratorPorAvaliacao() {
            livrosOrdenados = new ArrayList<>(livros);
            Collections.sort(livrosOrdenados, new Comparator<Livro>() {
                @Override
                public int compare(Livro l1, Livro l2) {
                    return Double.compare(l2.getAvaliacao(), l1.getAvaliacao());
                }
            });
        }
        
        @Override
        public boolean hasNext() {
            return posicao < livrosOrdenados.size();
        }
        
        @Override
        public Livro next() {
            if (hasNext()) {
                return livrosOrdenados.get(posicao++);
            }
            return null;
        }
        
        @Override
        public void remove() {
            if (posicao > 0) {
                Livro livroAtual = livrosOrdenados.get(posicao - 1);
                livros.removeIf(l -> l.getTitulo().equals(livroAtual.getTitulo()));
            }
        }
    }
}

