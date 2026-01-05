package structural.decorator;

public class Main {
    public static void main(String[] args) {
        Cafeteria cafeteria = new Cafeteria();
        
        System.out.println("=== SISTEMA DE CAFETERIA - PADRÃO DECORATOR ===\n");
        
        // Cenário 1: Café Expresso com Leite e Chocolate
        System.out.println("1. Café Expresso com Leite e Chocolate:");
        Cafe cafe1 = new CafeExpresso();
        cafe1 = new LeiteDecorator(cafe1);
        cafe1 = new ChocolateDecorator(cafe1);
        cafeteria.mostrarPedido(cafe1);
        
        // Cenário 2: Café Simples com Duplo Chocolate e Chantilly
        System.out.println("2. Café Simples com Duplo Chocolate e Chantilly:");
        Cafe cafe2 = new CafeSimples();
        cafe2 = new ChocolateDecorator(cafe2);
        cafe2 = new ChocolateDecorator(cafe2); // Duplo chocolate
        cafe2 = new ChantillyDecorator(cafe2);
        cafeteria.mostrarPedido(cafe2);
        
        // Cenário 3: Café com Leite com Canela e Caramelo
        System.out.println("3. Café com Leite com Canela e Caramelo:");
        Cafe cafe3 = new CafeComLeite();
        cafe3 = new CanelaDecorator(cafe3);
        cafe3 = new CarameloDecorator(cafe3);
        cafeteria.mostrarPedido(cafe3);
        
        // Cenário 4: Café Expresso com Leite, Chocolate e Chantilly
        System.out.println("4. Café Expresso com Leite, Chocolate e Chantilly:");
        Cafe cafe4 = new CafeExpresso();
        cafe4 = new LeiteDecorator(cafe4);
        cafe4 = new ChocolateDecorator(cafe4);
        cafe4 = new ChantillyDecorator(cafe4);
        cafeteria.mostrarPedido(cafe4);
        
        // Cenário 5: Pedido complexo personalizado
        System.out.println("5. Pedido Complexo Personalizado:");
        Cafe cafe5 = new CafeExpresso();
        cafe5 = new LeiteDecorator(cafe5);
        cafe5 = new ChocolateDecorator(cafe5);
        cafe5 = new ChocolateDecorator(cafe5); // Chocolate extra
        cafe5 = new ChantillyDecorator(cafe5);
        cafe5 = new CarameloDecorator(cafe5);
        cafeteria.mostrarPedido(cafe5);
        
        // Demonstração do Open/Closed Principle
        System.out.println("6. Adicionando Novo Ingrediente (Open/Closed):");
        // Novo decorator sem modificar código existente
        class BaunilhaDecorator extends CafeDecorator {
            public BaunilhaDecorator(Cafe cafe) {
                super(cafe);
            }
            
            @Override
            public String getDescricao() {
                return cafeDecorado.getDescricao() + " + Baunilha";
            }
            
            @Override
            public double getCusto() {
                return cafeDecorado.getCusto() + 0.60;
            }
        }
        
        Cafe cafe6 = new CafeSimples();
        cafe6 = new BaunilhaDecorator(cafe6);
        cafeteria.mostrarPedido(cafe6);
        
        // Verificação dos cálculos
        System.out.println("\n=== VERIFICAÇÃO DOS CÁLCULOS ===");
        System.out.println("Café 1: Esperado R$ 4,50 | Calculado: R$ " + String.format("%.2f", cafe1.getCusto()));
        System.out.println("Café 2: Esperado R$ 4,75 | Calculado: R$ " + String.format("%.2f", cafe2.getCusto()));
        System.out.println("Café 3: Esperado R$ 3,55 | Calculado: R$ " + String.format("%.2f", cafe3.getCusto()));
        System.out.println("Café 4: Esperado R$ 5,25 | Calculado: R$ " + String.format("%.2f", cafe4.getCusto()));
        
        // Demonstração de flexibilidade
        System.out.println("\n=== FLEXIBILIDADE DO SISTEMA ===");
        System.out.println("Número total de combinações possíveis com 3 cafés base e 5 ingredientes:");
        System.out.println("3 × 2^5 = " + (3 * Math.pow(2, 5)) + " combinações possíveis!");
        System.out.println("Todas implementadas com apenas 8 classes (3 cafés + 1 decorator abstrato + 5 decorators)");
    }
}
