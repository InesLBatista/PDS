package Praticas.lab11.ex1;
import java.util.*;

// Implementação do estado Leilao no padrão State - produto aceita lances com tempo limite
public class EstadoLeilao implements EstadoProduto {
    private Timer timer;

    @Override
    public boolean podeReceberLances() {
        return true;
    }

    @Override
    public boolean processarLance(Produto produto, double valor, Cliente cliente) {
        if(valor <= produto.getMaiorLance()) {
            System.out.println("Lance de " + valor + " é inferior ao maior lance atual " + produto.getMaiorLance());
            return false;
        }

        if (valor <= produto.getPrecoBase()) {
            System.out.println("Lance de " + valor + " é inferior ao preço base " + produto.getPrecoBase());
            return false;
        }

        produto.setMaiorLance(valor);
        produto.setLicitadorAtual(cliente);

        String mensagem = "Novo Lance: " + produto.getDescricao() + " a " + valor + " por " + cliente.getNome();
        produto.notificarObservadores(mensagem);

        System.out.println("Lance Aceite: " + mensagem);
        return true;
    }

    @Override
    public String getNomeEstado() {
        return "Leilao";
    }

    @Override
    public void gerirEstado(Produto produto) {
        produto.setTempoInicioLeilao(System.currentTimeMillis());
        System.out.println("Produto " + produto.getDescricao() + " colocado em leilão por " + produto.getTempoMaximoLeilao() + " segundos");
        iniciarTimerLeilao(produto);
    }

    private void iniciarTimerLeilao(Produto produto) {
        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finalizarLeilao(produto);
            }
        }, produto.getTempoMaximoLeilao() * 1000);
    }

    private void finalizarLeilao(Produto produto) {
        SistemaLeiloes.getInstancia().removerProdutoDeLeilao(produto);

        if (produto.getLicitadorAtual() != null) {
            produto.setEstado(new EstadoVendido());
            String mensagem = "Venda realizada: " + produto.getDescricao() + " vendido por " + produto.getMaiorLance() + " para " + produto.getLicitadorAtual().getNome();
            produto.notificarObservadores(mensagem);
        } else {
            produto.setEstado(new EstadoStock());
            produto.notificarObservadores("Leilão terminado: " + produto.getDescricao() + " não foi vendido");
        }

        timer = null;
    }
}