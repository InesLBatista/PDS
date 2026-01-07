package behavioral.visitor;

// VisitorRelatorio.java - Visitor concreto
public class VisitorRelatorio implements Visitor {
    private int totalDocumentos = 0;
    private long tamanhoTotal = 0;
    
    @Override
    public void visitar(DocumentoTexto documento) {
        totalDocumentos++;
        tamanhoTotal += documento.getTamanho();
        System.out.println("Processando para relatorio - Texto: " + documento.getNome());
    }
    
    @Override
    public void visitar(DocumentoPDF documento) {
        totalDocumentos++;
        tamanhoTotal += documento.getTamanho();
        System.out.println("Processando para relatorio - PDF: " + documento.getNome());
    }
    
    @Override
    public void visitar(DocumentoImagem documento) {
        totalDocumentos++;
        tamanhoTotal += documento.getTamanho();
        System.out.println("Processando para relatorio - Imagem: " + documento.getNome());
    }
    
    @Override
    public void visitar(DocumentoPlanilha documento) {
        totalDocumentos++;
        tamanhoTotal += documento.getTamanho();
        System.out.println("Processando para relatorio - Planilha: " + documento.getNome());
    }
    
    @Override
    public void visitar(DocumentoApresentacao documento) {
        totalDocumentos++;
        tamanhoTotal += documento.getTamanho();
        System.out.println("Processando para relatorio - Apresentacao: " + documento.getNome());
    }
    
    public void gerarRelatorio() {
        System.out.println("\n=== RELATORIO DE DOCUMENTOS ===");
        System.out.println("Total de documentos: " + totalDocumentos);
        System.out.println("Tamanho total: " + tamanhoTotal + " bytes");
        System.out.println("Tamanho medio: " + (totalDocumentos > 0 ? tamanhoTotal / totalDocumentos : 0) + " bytes");
        System.out.println("===============================");
    }
    
    public void reset() {
        totalDocumentos = 0;
        tamanhoTotal = 0;
    }
}
