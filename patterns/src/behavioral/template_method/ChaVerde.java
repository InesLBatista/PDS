package behavioral.template_method;

// ChaVerde.java
public class ChaVerde extends Cha {
    
    @Override
    protected void aquecerAgua() {
        System.out.println("A aquecer agua a 80 graus para o cha verde (temperatura mais baixa)");
    }
    
    @Override
    protected void adicionarIngredientePrincipal() {
        System.out.println("A colocar folhas de cha verde na chavena");
    }
    
    @Override
    protected void mexer() {
        System.out.println("A deixar o cha verde em infusao durante 2 minutos (tempo mais curto)");
    }
    
    @Override
    protected boolean clienteQuerCondimentos() {
        // Cha verde normalmente nao leva condimentos
        return false;
    }
}
