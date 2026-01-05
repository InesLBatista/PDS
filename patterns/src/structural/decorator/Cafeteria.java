package structural.decorator;

public class Cafeteria {
    public void mostrarPedido(Cafe cafe) {
        System.out.println("Pedido: " + cafe.getDescricao());
        System.out.println("Custo: R$ " + String.format("%.2f", cafe.getCusto()));
        System.out.println("---");
    }
}
