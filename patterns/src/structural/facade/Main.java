package structural.facade;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE HOME THEATER - PADRÃO FACADE ===\n");
        
        // 1. Criar os componentes do subsistema complexo
        Amplificador amplificador = new Amplificador();
        LeitorBluRay leitorBluRay = new LeitorBluRay();
        Projetor projetor = new Projetor();
        SistemaDeLuzes luzes = new SistemaDeLuzes();
        EcrãProjecção ecrã = new EcrãProjecção();
        MáquinaDePipocas máquinaPipocas = new MáquinaDePipocas();
        
        // 2. Criar a fachada (interface simplificada)
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
            amplificador, leitorBluRay, projetor, luzes, ecrã, máquinaPipocas
        );
        
        // 3. Cliente usa apenas a fachada (interface simplificada)
        
        // Cenário 1: Ver um filme completo
        System.out.println("CENÁRIO 1: VER UM FILME");
        homeTheater.verFilme("O Senhor dos Anéis: A Sociedade do Anel");
        
        // Simular tempo do filme
        try {
            Thread.sleep(2000); // Simula 2 segundos de filme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Finalizar filme
        homeTheater.fimDoFilme();
        
        // Cenário 2: Ouvir música
        System.out.println("CENÁRIO 2: OUVIR MÚSICA");
        homeTheater.ouvirMusica("Bohemian Rhapsody - Queen");
        
        // Simular tempo de música
        try {
            Thread.sleep(1500); // Simula 1.5 segundos de música
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Finalizar música
        homeTheater.fimDaMusica();
        
        // Cenário 3: Configurar modo jogo
        System.out.println("CENÁRIO 3: CONFIGURAR MODO JOGO");
        homeTheater.configurarModoJogo();
        
        // Cenário 4: Ver outro filme (demonstra reutilização)
        System.out.println("CENÁRIO 4: VER OUTRO FILME");
        homeTheater.verFilme("Matrix");
        
        // Simular tempo do filme
        try {
            Thread.sleep(1500); // Simula 1.5 segundos de filme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Finalizar filme
        homeTheater.fimDoFilme();
        
        // Demonstração de benefícios
        System.out.println("=== BENEFÍCIOS DO PADRÃO FACADE ===\n");
        
        System.out.println("1. SEM FACADE (Complexo):");
        System.out.println("   O utilizador precisa conhecer todos os componentes:");
        System.out.println("   - Ligar máquina de pipocas");
        System.out.println("   - Fazer pipocas");
        System.out.println("   - Atenuar luzes para 10%");
        System.out.println("   - Descer ecrã de projecção");
        System.out.println("   - Ligar projector");
        System.out.println("   - Configurar projector para widescreen");
        System.out.println("   - Ligar amplificador");
        System.out.println("   - Configurar entrada do amplificador");
        System.out.println("   - Ajustar volume");
        System.out.println("   - Ligar leitor de Blu-ray");
        System.out.println("   - Iniciar filme");
        System.out.println("   TOTAL: 12 passos manuais!");
        
        System.out.println("\n2. COM FACADE (Simplificado):");
        System.out.println("   O utilizador usa apenas um comando:");
        System.out.println("   - homeTheater.verFilme(\"Matrix\")");
        System.out.println("   TOTAL: 1 comando simples!");
        
        System.out.println("\n3. VANTAGENS:");
        System.out.println("   ✅ Interface simplificada");
        System.out.println("   ✅ Código do cliente mais limpo");
        System.out.println("   ✅ Facilita manutenção do subsistema");
        System.out.println("   ✅ Reduz acoplamento");
        System.out.println("   ✅ Melhora a usabilidade");
        
        // Verificação do isolamento
        System.out.println("\n=== VERIFICAÇÃO DO ISOLAMENTO ===");
        System.out.println("O cliente NÃO tem acesso directo aos componentes:");
        System.out.println("• amplificador.ligar() - ❌ Não acessível directamente");
        System.out.println("• homeTheater.verFilme() - ✅ Única interface necessária");
        
        System.out.println("\n=== SISTEMA FACADE IMPLEMENTADO COM SUCESSO! ===");
    }
}
