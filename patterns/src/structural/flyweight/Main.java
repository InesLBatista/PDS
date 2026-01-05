package structural.flyweight;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PADRÃO FLYWEIGHT - FLORESTA VIRTUAL ===\n");
        
        Random random = new Random();
        
        // 1. Criar tipos de árvores (flyweights)
        System.out.println("1. CRIANDO TIPOS DE ÁRVORES:");
        System.out.println("---------------------------");
        
        TipoArvore carvalho = FlorestaFactory.getTipoArvore("Carvalho", "Castanho", "Rugosa");
        TipoArvore pinheiro = FlorestaFactory.getTipoArvore("Pinheiro", "Verde", "Agulhas");
        TipoArvore eucalipto = FlorestaFactory.getTipoArvore("Eucalipto", "Cinza", "Lisa");
        
        // Tentar criar duplicado - não deve criar novo
        TipoArvore carvalho2 = FlorestaFactory.getTipoArvore("Carvalho", "Castanho", "Rugosa");
        
        System.out.println("Tipos únicos criados: " + FlorestaFactory.getNumeroTiposCriados());
        System.out.println("   (1 tipo reutilizado)\n");
        
        // 2. Criar floresta com 20 árvores
        System.out.println("2. CRIANDO FLORESTA (20 árvores):");
        System.out.println("-------------------------------");
        
        Arvore[] floresta = new Arvore[20];
        TipoArvore[] tipos = {carvalho, pinheiro, eucalipto};
        
        for (int i = 0; i < floresta.length; i++) {
            TipoArvore tipo = tipos[random.nextInt(tipos.length)];
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            double altura = 10 + random.nextDouble() * 20;
            double largura = 5 + random.nextDouble() * 10;
            
            floresta[i] = new Arvore(x, y, altura, largura, tipo);
        }
        
        System.out.println("Floresta criada com " + floresta.length + " árvores\n");
        
        // 3. Renderizar algumas árvores
        System.out.println("3. RENDERIZANDO 5 ÁRVORES:");
        System.out.println("-----------------------");
        
        for (int i = 0; i < Math.min(5, floresta.length); i++) {
            System.out.printf("Árvore %d: ", i + 1);
            floresta[i].renderizar();
        }
        
        // 4. Verificar partilha
        System.out.println("\n4. VERIFICANDO PARTILHA:");
        System.out.println("----------------------");
        
        // Verificar se carvalho e carvalho2 são o mesmo objecto
        System.out.print("Carvalho == Carvalho2? ");
        System.out.println(carvalho == carvalho2 ? "✅ SIM (mesmo objecto)" : "❌ NÃO");
        
        // Contar quantas árvores partilham cada tipo
        int[] contagem = new int[3];
        for (Arvore arvore : floresta) {
            if (arvore.getTipo() == carvalho) contagem[0]++;
            else if (arvore.getTipo() == pinheiro) contagem[1]++;
            else contagem[2]++;
        }
        
        System.out.println("\nDISTRIBUIÇÃO:");
        System.out.println("Carvalhos: " + contagem[0] + " árvores");
        System.out.println("Pinheiros: " + contagem[1] + " árvores");
        System.out.println("Eucaliptos: " + contagem[2] + " árvores");
        
        // 5. Demonstração de economia
        System.out.println("\n5. DEMONSTRAÇÃO DE ECONOMIA:");
        System.out.println("--------------------------");
        
        System.out.println("Objectos TipoArvore na memória: " + FlorestaFactory.getNumeroTiposCriados());
        System.out.println("Objectos Arvore na memória: " + floresta.length);
        
        // Cálculo simplificado de memória
        int memoriaSemFlyweight = floresta.length * 7; // 7 campos por árvore
        int memoriaComFlyweight = FlorestaFactory.getNumeroTiposCriados() * 3 + floresta.length * 4;
        
        System.out.println("\nCOMPARAÇÃO DE MEMÓRIA:");
        System.out.println("Sem Flyweight: ~" + memoriaSemFlyweight + " unidades");
        System.out.println("Com Flyweight: ~" + memoriaComFlyweight + " unidades");
        
        double economia = 100.0 * (memoriaSemFlyweight - memoriaComFlyweight) / memoriaSemFlyweight;
        System.out.printf("Economia: %.1f%%\n", economia);
        
        System.out.println("\n=== PADRÃO FLYWEIGHT DEMONSTRADO COM SUCESSO ===");
    }
}