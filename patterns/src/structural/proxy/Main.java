package structural.proxy;
public class Main {
    public static void main(String[] args) {
        System.out.println("Padrão Proxy - Sistema de Documentos\n");
        
        // Criar alguns documentos reais
        DocumentoReal docPublico = new DocumentoReal("Relatório público");
        DocumentoReal docRestrito = new DocumentoReal("Relatório restrito - financeiro");
        DocumentoReal docConfidencial = new DocumentoReal("Documento confidencial - estratégia");
        
        System.out.println("\n================================================================");
        
        // 1. Teste: Acesso simples sem proxy
        System.out.println("\n1. Teste: acesso directo ao documento real");
        System.out.println("-------------------------------------------");
        docPublico.mostrar();
        
        System.out.println("\n================================================================");
        
        // 2. Teste: Proxy de segurança
        System.out.println("\n2. Teste: proxy de segurança");
        System.out.println("----------------------------");
        
        // Criar proxies de segurança para diferentes utilizadores
        ProxySegurança proxyAdmin = new ProxySegurança(docConfidencial, "admin", "admin");
        ProxySegurança proxyGerente = new ProxySegurança(docRestrito, "joao", "gerente");
        ProxySegurança proxyNormal = new ProxySegurança(docConfidencial, "maria", "funcionario");
        
        System.out.println("\n--- Teste com admin (deve ter acesso) ---");
        proxyAdmin.mostrar();
        
        System.out.println("\n--- Teste com gerente (acesso restrito) ---");
        proxyGerente.mostrar();
        
        System.out.println("\n--- Teste com funcionário (acesso negado) ---");
        proxyNormal.mostrar();
        
        System.out.println("\n================================================================");
        
        // 3. Teste: Proxy de cache
        System.out.println("\n3. Teste: proxy de cache");
        System.out.println("------------------------");
        
        ProxyCache proxyCache = new ProxyCache(docPublico);
        
        System.out.println("\n--- Primeira visualização (miss) ---");
        long inicio = System.currentTimeMillis();
        proxyCache.mostrar();
        long fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio) + "ms");
        
        System.out.println("\n--- Segunda visualização (hit) ---");
        inicio = System.currentTimeMillis();
        proxyCache.mostrar();
        fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio) + "ms");
        
        System.out.println("\n--- Invalidação do cache ---");
        proxyCache.invalidarCache();
        
        System.out.println("\n--- Terceira visualização (miss novamente) ---");
        inicio = System.currentTimeMillis();
        proxyCache.mostrar();
        fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio) + "ms");
        
        System.out.println("\n================================================================");
        
        // 4. Teste: Proxy de logging
        System.out.println("\n4. Teste: proxy de logging");
        System.out.println("--------------------------");
        
        ProxyLogging proxyLogging = new ProxyLogging(docPublico);
        proxyLogging.mostrar();
        
        System.out.println("\n================================================================");
        
        // 5. Teste: Proxy virtual (lazy loading)
        System.out.println("\n5. Teste: proxy virtual (lazy loading)");
        System.out.println("---------------------------------------");
        
        System.out.println("Criando ProxyVirtual...");
        ProxyVirtual proxyVirtual = new ProxyVirtual("Documento virtual - pesquisa");
        
        System.out.println("\nDocumento ainda não carregado (objecto real não criado)");
        System.out.println("Título disponível: " + proxyVirtual.getTitulo());
        
        System.out.println("\n--- Primeiro acesso (inicializa o objecto real) ---");
        inicio = System.currentTimeMillis();
        proxyVirtual.mostrar();
        fim = System.currentTimeMillis();
        System.out.println("Tempo total: " + (fim - inicio) + "ms");
        
        System.out.println("\n--- Segundo acesso (objecto já carregado) ---");
        inicio = System.currentTimeMillis();
        proxyVirtual.mostrar();
        fim = System.currentTimeMillis();
        System.out.println("Tempo total: " + (fim - inicio) + "ms");
        
        System.out.println("\n================================================================");
        
        // 6. Teste: Proxies combinados (decorator pattern com proxies)
        System.out.println("\n6. Teste: proxies combinados");
        System.out.println("----------------------------");
        
        System.out.println("Criando cadeia de proxies: Virtual -> Cache -> Segurança -> Logging");
        
        // Começa com proxy virtual
        ProxyVirtual virtualBase = new ProxyVirtual("Documento combinado - importante");
        
        // Adiciona cache
        ProxyCache comCache = new ProxyCache(virtualBase);
        
        // Adiciona segurança
        ProxySegurança comSegurança = new ProxySegurança(
            new DocumentoReal("Documento combinado - importante"), "admin", "admin");
        
        // Adiciona logging (wrapper em volta de tudo)
        ProxyLogging proxyCompleto = new ProxyLogging(comSegurança);
        
        System.out.println("\n--- Acesso através de todos os proxies ---");
        proxyCompleto.mostrar();
        
        System.out.println("\n================================================================");
        
        // 7. Demonstração de transparência para o cliente
        System.out.println("\n7. Demonstração: transparência para o cliente");
        System.out.println("----------------------------------------------");
        
        // O cliente trabalha apenas com a interface Documento
        Documento[] documentos = new Documento[3];
        documentos[0] = docPublico;  // Objecto real
        documentos[1] = proxyCache;   // Proxy de cache
        documentos[2] = proxyVirtual; // Proxy virtual
        
        System.out.println("\nCliente acessa documentos (não sabe se são reais ou proxies):");
        for (int i = 0; i < documentos.length; i++) {
            System.out.println("\n--- Documento " + (i+1) + " ---");
            documentos[i].mostrar();
        }
    }
}