package behavioral.template_method;

// Cha.java
public class Cha extends BebidaQuenteTemplate {
    
    @Override
    protected void aquecerAgua() {
        System.out.println("A aquecer agua a 85 graus para o cha");
    }
    
    @Override
    protected void adicionarIngredientePrincipal() {
        System.out.println("A colocar saquinho de cha na chavena");
    }
    
    @Override
    protected void mexer() {
        System.out.println("A deixar o cha em infusao durante 3 minutos");
    }
    
    @Override
    protected void adicionarCondimentos() {
        System.out.println("A adicionar limao e mel");
    }
    
    @Override
    protected boolean clienteQuerCondimentos() {
        // Simulacao: 80% dos clientes querem condimentos no cha
        return Math.random() > 0.2;
    }
}
