package behavioral.template_method;

public abstract class BebidaQuenteTemplate {
    
    // Metodo template FINAL - define a sequencia fixa de preparacao
    public final void prepararBebida() {
        aquecerAgua();
        adicionarIngredientePrincipal();
        mexer();
        if (clienteQuerCondimentos()) {
            adicionarCondimentos();
        }
        servir();
    }
    
    // Passos abstratos que as subclasses DEVEM implementar
    protected abstract void aquecerAgua();
    protected abstract void adicionarIngredientePrincipal();
    protected abstract void mexer();
    
    // Hook opcional - subclasses PODEM sobrescrever
    protected void adicionarCondimentos() {
        // Implementacao padrao vazia
    }
    
    // Hook para controle - subclasses PODEM sobrescrever
    protected boolean clienteQuerCondimentos() {
        return true; // Padrao: adiciona condimentos
    }
    
    // Metodo comum a todas as bebidas
    protected void servir() {
        System.out.println("A servir a bebida numa chavena quente!");
    }
}