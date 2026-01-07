package behavioral.visitor;

// VisitorValidacao.java - Visitor concreto
public class VisitorValidacao implements Visitor {
    
    @Override
    public void visitar(DocumentoTexto documento) {
        System.out.println("Validando documento de texto: " + documento.getNome());
        System.out.println("  Verificando encoding UTF-8...");
        System.out.println("  Validando tamanho maximo (10MB)...");
        System.out.println("  Documento de texto validado com sucesso.");
    }
    
    @Override
    public void visitar(DocumentoPDF documento) {
        System.out.println("Validando documento PDF: " + documento.getNome());
        System.out.println("  Verificando integridade do PDF...");
        System.out.println("  Validando numero de paginas: " + documento.getNumeroPaginas());
        System.out.println("  Documento PDF validado com sucesso.");
    }
    
    @Override
    public void visitar(DocumentoImagem documento) {
        System.out.println("Validando documento de imagem: " + documento.getNome());
        System.out.println("  Verificando resolucao: " + documento.getResolucao());
        System.out.println("  Validando formato de imagem...");
        System.out.println("  Documento de imagem validado com sucesso.");
    }
    
    @Override
    public void visitar(DocumentoPlanilha documento) {
        System.out.println("Validando documento de planilha: " + documento.getNome());
        System.out.println("  Verificando estrutura de celulas...");
        System.out.println("  Validando formulas...");
        System.out.println("  Documento de planilha validado com sucesso.");
    }
    
    @Override
    public void visitar(DocumentoApresentacao documento) {
        System.out.println("Validando documento de apresentacao: " + documento.getNome());
        System.out.println("  Verificando numero de slides: " + documento.getNumeroSlides());
        System.out.println("  Validando transicoes...");
        System.out.println("  Documento de apresentacao validado com sucesso.");
    }
}
