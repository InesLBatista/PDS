package behavioral.iterator;

interface ColecaoLivros<T> {
    Iterator<T> criarIterator();
    void adicionarLivro(T livro);
    int getTamanho();
}
