package behavioral.template_method;
// ChocolateQuente.java
public class ChocolateQuente extends BebidaQuenteTemplate {
    
    @Override
    protected void aquecerAgua() {
        System.out.println("A aquecer leite a 70 graus para o chocolate quente");
    }
    
    @Override
    protected void adicionarIngredientePrincipal() {
        System.out.println("A adicionar po de chocolate na chavena");
    }
    
    @Override
    protected void mexer() {
        System.out.println("A mexer vigorosamente para dissolver o chocolate");
    }
    
    @Override
    protected void adicionarCondimentos() {
        System.out.println("A adicionar canela e natas");
    }
    
    @Override
    protected boolean clienteQuerCondimentos() {
        // Chocolate quente quase sempre tem condimentos
        return true;
    }
}
