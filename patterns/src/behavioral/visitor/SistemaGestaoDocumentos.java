package behavioral.visitor;

// SistemaGestaoDocumentos.java - Cliente principal
public class SistemaGestaoDocumentos {
    
    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestao de Documentos (Padrao Visitor) ===\n");
        
        // Criar colecao de documentos
        ColecaoDocumentos colecao = new ColecaoDocumentos();
        
        // Adicionar documentos de diferentes tipos
        colecao.adicionarDocumento(new DocumentoTexto("relatorio.txt", 1024));
        colecao.adicionarDocumento(new DocumentoPDF("manual.pdf", 204800, 50));
        colecao.adicionarDocumento(new DocumentoImagem("foto.jpg", 512000, "1920x1080"));
        colecao.adicionarDocumento(new DocumentoPlanilha("dados.xlsx", 307200, 1000, 20));
        colecao.adicionarDocumento(new DocumentoApresentacao("apresentacao.pptx", 409600, 30));
        
        System.out.println("Colecao criada com " + colecao.getNumeroDocumentos() + " documentos.\n");
        
        // Aplicar diferentes visitors
        System.out.println("1. Exportando documentos:");
        System.out.println("----------------------------");
        Visitor exportacao = new VisitorExportacao();
        colecao.aceitarVisitor(exportacao);
        
        System.out.println("\n2. Validando documentos:");
        System.out.println("----------------------------");
        Visitor validacao = new VisitorValidacao();
        colecao.aceitarVisitor(validacao);
        
        System.out.println("\n3. Comprimindo documentos:");
        System.out.println("----------------------------");
        Visitor compressao = new VisitorCompressao();
        colecao.aceitarVisitor(compressao);
        
        System.out.println("\n4. Gerando relatorio:");
        System.out.println("----------------------------");
        VisitorRelatorio relatorio = new VisitorRelatorio();
        colecao.aceitarVisitor(relatorio);
        relatorio.gerarRelatorio();
        
        // Demonstrar adicao de novo visitor sem modificar documentos
        demonstrarNovoVisitor(colecao);
    }
    
    private static void demonstrarNovoVisitor(ColecaoDocumentos colecao) {
        System.out.println("\n5. Demonstrando adicao de novo visitor:");
        System.out.println("----------------------------------------");
        
        // Criar novo visitor sem modificar as classes de documento
        Visitor conversao = new Visitor() {
            @Override
            public void visitar(DocumentoTexto documento) {
                System.out.println("Convertendo texto para HTML: " + documento.getNome());
            }
            
            @Override
            public void visitar(DocumentoPDF documento) {
                System.out.println("Convertendo PDF para texto: " + documento.getNome());
            }
            
            @Override
            public void visitar(DocumentoImagem documento) {
                System.out.println("Convertendo imagem para WebP: " + documento.getNome());
            }
            
            @Override
            public void visitar(DocumentoPlanilha documento) {
                System.out.println("Convertendo planilha para JSON: " + documento.getNome());
            }
            
            @Override
            public void visitar(DocumentoApresentacao documento) {
                System.out.println("Convertendo apresentacao para video: " + documento.getNome());
            }
        };
        
        colecao.aceitarVisitor(conversao);
    }
}
