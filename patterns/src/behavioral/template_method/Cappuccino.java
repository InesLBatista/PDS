package behavioral.template_method;

// Cappuccino.java
public class Cappuccino extends BebidaQuenteTemplate {
    
    @Override
    protected void aquecerAgua() {
        System.out.println("A aquecer agua a 92 graus para o cappuccino");
    }
    
    @Override
    protected void adicionarIngredientePrincipal() {
        System.out.println("A preparar cafe expresso para o cappuccino");
    }
    
    @Override
    protected void mexer() {
        System.out.println("A espumar o leite para o cappuccino");
    }
    
    @Override
    protected void adicionarCondimentos() {
        System.out.println("A polvilhar cacau em po");
    }
    
    @Override
    protected void servir() {
        System.out.println("A servir o cappuccino numa chavena larga com desenho no leite");
    }
}
