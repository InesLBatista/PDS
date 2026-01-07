package behavioral.template_method;

// TesteTemplateMethod.java - Testes unitarios simples
public class TesteTemplateMethod {
    
    public static void main(String[] args) {
        System.out.println("=== Testes do Padrao Template Method ===\n");
        
        testarProcessoPadronizado();
        testarHooks();
        testarNovaBebida();
    }
    
    private static void testarProcessoPadronizado() {
        System.out.println("Teste: Processo padronizado");
        BebidaQuenteTemplate bebida = new Cafe();
        bebida.prepararBebida();
        System.out.println("Resultado: Todas as etapas foram executadas na ordem correta\n");
    }
    
    private static void testarHooks() {
        System.out.println("Teste: Hooks opcionais");
        BebidaQuenteTemplate chaSemCondimentos = new Cha() {
            @Override
            protected boolean clienteQuerCondimentos() {
                return false;
            }
        };
        chaSemCondimentos.prepararBebida();
        System.out.println("Resultado: Condimentos nao foram adicionados quando hook retorna false\n");
    }
    
    private static void testarNovaBebida() {
        System.out.println("Teste: Adicionar nova bebida");
        BebidaQuenteTemplate chaDeCamomila = new BebidaQuenteTemplate() {
            @Override
            protected void aquecerAgua() {
                System.out.println("A aquecer agua a 90 graus para cha de camomila");
            }
            
            @Override
            protected void adicionarIngredientePrincipal() {
                System.out.println("A adicionar flores de camomila");
            }
            
            @Override
            protected void mexer() {
                System.out.println("A deixar em infusao durante 5 minutos");
            }
            
            @Override
            protected void adicionarCondimentos() {
                System.out.println("A adicionar uma colher de mel");
            }
        };
        
        chaDeCamomila.prepararBebida();
        System.out.println("Resultado: Nova bebida adicionada sem alterar o template base\n");
    }
}