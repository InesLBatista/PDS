package Praticas.lab11.ex1;

// Cliente que implementa Observador para receber notificações de produtos
public class Cliente implements Observador {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
        System.out.println("Cliente criado: " + nome);
    }

    public String getNome() {
        return nome;
    }
    
    public void licitar(Produto produto, double valor) {
        System.out.println(nome + " a licitar " + valor + " no " + produto.getDescricao());
        boolean sucesso = SistemaLeiloes.getInstancia().processarLance(this, produto, valor);
        if (sucesso) {
            produto.registarObservador(this);
        }
    }

    public void consultarProdutosLeilao() {
        System.out.println(nome + " a consultar produtos em leilão");
        var produtosLeilao = SistemaLeiloes.getInstancia().getProdutosEmLeilao();
        if (produtosLeilao.isEmpty()) {
            System.out.println("Não há produtos em leilão de momento");
        } else {
            produtosLeilao.forEach(System.out::println);
        }
    }

    public void consultarProdutosPorDescricao(String descricao) {
        System.out.println(nome + " a pesquisar produtos com: " + descricao);
        var produtosEncontrados = SistemaLeiloes.getInstancia().getProdutosEmLeilao()
            .stream()
            .filter(p -> p.getDescricao().toLowerCase().contains(descricao.toLowerCase()))
            .toList();
        if (produtosEncontrados.isEmpty()) {
            System.out.println("Nenhum produto encontrado com a descrição: " + descricao);
        } else {
            produtosEncontrados.forEach(System.out::println);
        }
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("[CLIENTE " + nome.toUpperCase() + "] " + mensagem);
    }

    @Override
    public String toString() {
        return "Cliente: " + nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return nome.equalsIgnoreCase(cliente.nome);
    }

    @Override
    public int hashCode() {
        return nome.toLowerCase().hashCode();
    }
}