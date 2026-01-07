package behavioral.template_method;

// Cafe.java
public class Cafe extends BebidaQuenteTemplate {
    
    @Override
    protected void aquecerAgua() {
        System.out.println("A aquecer agua a 96 graus para o cafe");
    }
    
    @Override
    protected void adicionarIngredientePrincipal() {
        System.out.println("A adicionar po de cafe na chavena");
    }
    
    @Override
    protected void mexer() {
        System.out.println("A mexer o cafe durante 15 segundos");
    }
    
    @Override
    protected void adicionarCondimentos() {
        System.out.println("A adicionar acucar (opcional)");
    }
    
    @Override
    protected boolean clienteQuerCondimentos() {
        // Simulacao: 70% dos clientes querem acucar
        return Math.random() > 0.3;
    }
}